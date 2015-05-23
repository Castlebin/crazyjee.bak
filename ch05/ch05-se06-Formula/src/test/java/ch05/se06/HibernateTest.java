package ch05.se06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import ch05.se06.domain.News;

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
		
		News n = new News();
		n.setTitle("股市大涨！");
		n.setContent("受国家战略驱动，股市出现爆发性增长，大批广场舞大妈入市，股市迎来新一轮的春天。");
		
		// 保存
		session.save(n);
		
		// 实体现在处于持久化状态，所以现在已经有了id了
		System.out.println(n.getId());
		System.out.println(n.getFullContent());
		
		// 提交事务
		tx.commit();
		
		// 执行资源关闭操作
		session.close();
		
		Session s = sf.openSession();
		News nn = (News)s.get(News.class, n.getId());
		System.out.println(nn.getFullContent());
		
		sf.close();
	}

}
