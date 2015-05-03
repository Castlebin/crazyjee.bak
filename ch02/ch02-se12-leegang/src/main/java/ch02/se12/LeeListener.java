package ch02.se12;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LeeListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("--------LeeListener模块被加载了--------");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("--------销毁LeeListener模块--------");
	}
}