package ch06.se04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import ch06.se04.domain.Person;

public class HibernateTest {
	
	@Test
	public void testFindPerson() {
		//  实例化Configuration
		Configuration cfg = new Configuration()
			.configure();//configure()默认使用hibernate.cfg.xml，它可接受一个字符串参数，用于加载其他名字的配置文件
		
		// 获得SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		
		// 创建Session
		Session session = sf.openSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		
		
		@SuppressWarnings("unchecked")
		List<Person> personList = (List<Person>)session.createQuery("select distinct p from Person p "
				+ "join p.myEvents where title = :eventTitle")
				.setParameter("eventTitle", "很普通的事情")
				.list();
		for(Person p : personList) {
			System.out.println(p.getName());
		}
		
		
		// 提交事务
		tx.commit();
		
		// 执行资源关闭操作
		session.close();
		sf.close();
	}
	@Test
	public void testFindPersonByDate() throws ParseException {
		//  实例化Configuration
		Configuration cfg = new Configuration()
		.configure();//configure()默认使用hibernate.cfg.xml，它可接受一个字符串参数，用于加载其他名字的配置文件
		
		// 获得SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		
		// 创建Session
		Session session = sf.openSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = sdf.parse("2005-01-01");
		
		@SuppressWarnings("unchecked")
		List<Person> personList = (List<Person>)session.createQuery("select distinct p from Person p "
				+ "inner join p.myEvents event where event.happenDate "
				+ "between :firstDate and :endDate")
				// 设置参数
				.setDate("firstDate" , start)
				.setDate("endDate" , new Date())
				// 返回结果集
				.list();
		for(Person p : personList) {
			System.out.println(p.getName());
		}
		
		
		// 提交事务
		tx.commit();
		
		// 执行资源关闭操作
		session.close();
		sf.close();
	}

}
