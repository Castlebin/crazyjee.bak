package ch02.se10;

import java.sql.ResultSet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebListener
public class RequestListener implements ServletRequestListener {
	// 当用户请求到达、被初始化时触发该方法
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre
				.getServletRequest();
		HttpSession session = request.getSession();
		// 获取session ID
		String sessionId = session.getId();
		// 获取访问的IP和正在访问的页面
		String ip = request.getRemoteAddr();
		String page = request.getRequestURI();
		String user = (String) session.getAttribute("user");
		// 未登录用户当游客处理
		user = (user == null) ? "游客" : user;
		try {
			DbDao dd = new DbDao("com.mysql.jdbc.Driver",
					"jdbc:mysql://localhost:3306/crazyjee", "root", "123456");
			ResultSet rs = dd.query(
					"select * from online_inf where session_id=?", true,
					sessionId);
			// 如果该用户对应的session ID存在，表明是旧的会话
			if (rs.next()) {
				// 更新记录
				rs.updateString(4, page);
				rs.updateLong(5, System.currentTimeMillis());
				rs.updateRow();
				rs.close();
			} else {
				// 插入该用户的在线信息
				dd.insert("insert into online_inf values(? , ? , ? , ? , ?)",
						sessionId, user, ip, page, System.currentTimeMillis());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 当用户请求结束、被销毁时触发该方法
	public void requestDestroyed(ServletRequestEvent sre) {
	}
}