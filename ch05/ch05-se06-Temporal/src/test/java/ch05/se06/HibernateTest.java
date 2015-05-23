package ch05.se06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import ch05.se06.domain.News;

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
		// 创建消息对象
		News n = new News();
		// 设置消息标题和消息内容
		n.setTitle("疯狂Java联盟成立了");
		n.setContent("疯狂Java联盟成立了，" + "网站地址http://www.crazyit.org.hhhhhhhhh");
		n.setDate(new Date());
		
		// 保存消息
		sess.save(n);
		// 输出fullContent值
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}

}
