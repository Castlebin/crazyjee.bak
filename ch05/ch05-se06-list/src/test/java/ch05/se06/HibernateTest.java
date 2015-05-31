package ch05.se06;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import ch05.se06.domain.Person;

public class HibernateTest {

	@Test
	public void testHibernate() throws FileNotFoundException, IOException {
		// 实例化Configuration，
		Configuration conf = new Configuration()
		// 不带参数的configure()方法默认加载hibernate.cfg.xml文件，
		// 如果传入abc.xml作为参数，则不再加载hibernate.cfg.xml，改为加载abc.xml
				.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(conf.getProperties()).build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		
		
		Person p = new Person();
		p.setName("李刚");
		p.setAge(38);
		p.getSchools().add("万华小学");
		p.getSchools().add("万山中学");
		p.getSchools().add("孙子大学");
		
		sess.save(p);
		
		
		// 输出fullContent值
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}

}
