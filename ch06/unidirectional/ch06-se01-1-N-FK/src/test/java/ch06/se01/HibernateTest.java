package ch06.se01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import ch06.se01.domain.Address;
import ch06.se01.domain.Person;

public class HibernateTest {
	
	@Test
	public void testHibernate() {
		//  实例化Configuration
		Configuration cfg = new Configuration()
			.configure();//configure()默认使用hibernate.cfg.xml，它可接受一个字符串参数，用于加载其他名字的配置文件
		
		// 获得SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		
		// 创建Session
		Session session = sf.openSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		
		Person p = new Person();
		p.setName("heller");
		
		Address a = new Address();
		a.setAddressDetail("Google Road");
		Address a2 = new Address();
		a2.setAddressDetail("Google Road 2");
		
		p.getAddresses().add(a);
		p.getAddresses().add(a2);
		
		session.persist(p);
		
		// 提交事务
		tx.commit();
		
		// 执行资源关闭操作
		session.close();
		sf.close();
	}

}
