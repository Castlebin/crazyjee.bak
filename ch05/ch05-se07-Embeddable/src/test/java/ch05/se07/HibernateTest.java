package ch05.se07;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import ch05.se07.domain.Name;
import ch05.se07.domain.Person;
import ch05.se07.util.HibernateUtil;

public class HibernateTest {

	@Test
	public void testHibernate() throws FileNotFoundException, IOException {
		// 打开线程安全的Session对象
		Session session = HibernateUtil.currentSession();
		// 打开事务
		Transaction tx = session.beginTransaction();
		
		
		// 创建Person对象
		Person person = new Person();
		person.setAge(20);
		
		Name name = new Name();
		name.setFirst("heller");
		name.setLast("lee");
		
		person.setName(name);
		
		session.save(person);
		
		
		tx.commit();
		HibernateUtil.closeSession();
	}

}
