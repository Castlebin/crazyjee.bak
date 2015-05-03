package ch02.se12;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CrazyitListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("--------crazyit模块被加载了--------");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("--------销毁crazyit模块--------");
	}
}