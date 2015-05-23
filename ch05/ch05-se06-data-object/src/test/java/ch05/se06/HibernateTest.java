package ch05.se06;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
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
		
		SchemaExport se = new SchemaExport(conf);
		
		// 设置输出格式良好的sql脚本
		se.setFormat(true)
			.setOutputFile("db.sql")// 保存的文件名
			.create(true, true);// 输出并执行sql脚本
	}

}
