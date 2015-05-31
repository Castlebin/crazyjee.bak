package ch05.se06;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import ch05.se06.domain.Person;
import ch05.se06.util.HibernateUtil;

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
		person.setName("crazyit.org");
		// 向person的Map集合属性中添加key-value对
		person.getScores().put("语文", 67f);
		person.getScores().put("文学课", 88.8f);
		session.save(person);
		tx.commit();
		HibernateUtil.closeSession();
	}

}
