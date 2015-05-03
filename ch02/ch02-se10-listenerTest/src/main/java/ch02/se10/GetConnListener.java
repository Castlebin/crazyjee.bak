package ch02.se10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GetConnListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		// 释放资源
		ServletContext application = sce.getServletContext();
		Connection conn = (Connection) application.getAttribute("conn");
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 应用启动时，该方法被调用
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext application = sce.getServletContext();
			String driver = application.getInitParameter("driver");
			String url = application.getInitParameter("url");
			String user = application.getInitParameter("user");
			String pass = application.getInitParameter("pass");
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			// 将connection放入application域中
			application.setAttribute("conn", conn);
		} catch(Exception e) {
			System.out.println("获取数据库连接出现异常");
		}
	}

}
