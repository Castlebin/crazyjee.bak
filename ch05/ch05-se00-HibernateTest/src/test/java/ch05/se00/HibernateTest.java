package ch05.se00;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch05.se00.domain.Person;
import ch05.se00.util.HibernateUtil;

public class HibernateTest {
	private Session session;
	private Transaction tx;
	
	@Before
	public void before() {
		// 打开线程安全的Session对象
		session = HibernateUtil.currentSession();
		// 打开事务
		tx = session.beginTransaction();
	}
	
	@After
	public void after() {
		tx.commit();
		HibernateUtil.closeSession();
	}

	@Test
	public void testHibernate() throws FileNotFoundException, IOException {
		// 创建Person对象
		Person person = new Person();
		session.save(person);
		
		System.out.println(person.getAge());
		System.out.println(person.getBirth());
	}

}
