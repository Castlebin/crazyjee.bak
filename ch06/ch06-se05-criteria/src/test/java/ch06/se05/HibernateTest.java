package ch06.se05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import ch06.se05.domain.Enrolment;
import ch06.se05.domain.Student;

public class HibernateTest {

	@Test
	public void test1() {
		// 实例化Configuration
		Configuration cfg = new Configuration().configure();// configure()默认使用hibernate.cfg.xml，它可接受一个字符串参数，用于加载其他名字的配置文件

		// 获得SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();

		// 创建Session
		Session session = sf.openSession();
		// 开始事务
		Transaction tx = session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) session
				.createCriteria(Student.class)
				// 根据Student的属性进行过滤数据
				.add(Restrictions.gt("name", "a")).list();
		System.out.println("=====简单条件查询获取所有学生记录=====");
		for (Object obj : list) {
			Student s = (Student) obj;
			System.out.println(s.getName());
			Set<Enrolment> enrolments = s.getEnrolments();
			System.out.println("=====获取-" + s.getName() + "-的选课记录=====");
			for (Enrolment e : enrolments) {
				System.out.println(e.getCourse().getName());
			}
		}

		// 提交事务
		tx.commit();

		// 执行资源关闭操作
		session.close();
		sf.close();
	}

	@Test
	public void test2() throws ParseException {
		// 实例化Configuration
		Configuration cfg = new Configuration().configure();// configure()默认使用hibernate.cfg.xml，它可接受一个字符串参数，用于加载其他名字的配置文件

		// 获得SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();

		// 创建Session
		Session session = sf.openSession();
		// 开始事务
		Transaction tx = session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) session
				.createCriteria(Student.class)
				// 此处增加限制条件必须是Student实体存在的属性
				.add(Restrictions.gt("studentNumber", 20050231))
				// 如果要增加对Student的关联类的属性的限制
				// 则必须重新createCriteria()
				// 如果此关联属性是集合，则只要集合里任意一个对象的属性满足下面条件即可
				// .createCriteria("enrolments")
				// .add( Restrictions.gt("semester" , 2))
				.createAlias("enrolments", "en")
				.add(Restrictions.gt("en.semester", 2)).list();
		System.out.println("=====关联条件查询获取所有学生记录=====");
		for (Object obj : list) {
			Student s = (Student) obj;
			System.out.println(s.getName());
			Set<Enrolment> enrolments = s.getEnrolments();
			System.out.println("=====获取-" + s.getName() + "-的选课记录=====");
			for (Enrolment e : enrolments) {
				System.out.println(e.getCourse().getName());
			}
		}

		// 提交事务
		tx.commit();

		// 执行资源关闭操作
		session.close();
		sf.close();
	}

}
