package ch02.se10;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// HttpSessionListener可以监听session的创建和销毁，因此可以用来监听系统的在线用户
@WebListener
public class OnlineListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		// 获取sessionId
		String sessionId = session.getId();
		// 如果是一次新的会话
		if(session.isNew()) {
			String user = (String)session.getAttribute("user");
			// 未登录用户当做游客处理
			user = (user==null)? "游客": user;
			Map<String, String> online = (Map<String, String>)application.getAttribute("online");
			if(online == null) {
				online = new HashMap<>();
			}
			
			// 将在线用户放入map中
			online.put(sessionId, user);
			application.setAttribute("online", online);
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		// 获取sessionId
		String sessionId = session.getId();
		Map<String, String> online = (Map<String, String>)application.getAttribute("online");
		if(online != null) {
			online.remove(sessionId);
		}
		
		application.setAttribute("online", online);
	}

}
