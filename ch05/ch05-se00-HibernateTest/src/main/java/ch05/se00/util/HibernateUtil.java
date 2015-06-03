package ch05.se00.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	public static final SessionFactory sessionFactory;

	// ThreadLocal可以隔离多个线程的数据共享，因此不再需要对线程同步
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	
	static {
		try {
			// 使用默认的hibernate.cfg.xml配置文件创建Configuration实例
			Configuration cfg = new Configuration().configure();
			// 以Configuration实例来创建SessionFactory实例
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).build();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session currentSession() throws HibernateException {
		Session sess = session.get();
		// 如果该线程还没有Session,则创建一个新的Session
		if (sess == null) {
			sess = sessionFactory.openSession();
			// 将获得的Session变量存储在ThreadLocal变量session里
			session.set(sess);
		}
		
		return sess;
	}

	public static void closeSession() throws HibernateException {
		Session sess = session.get();
		if (sess != null) {
			sess.close();
		}
		
		session.set(null);
	}
}