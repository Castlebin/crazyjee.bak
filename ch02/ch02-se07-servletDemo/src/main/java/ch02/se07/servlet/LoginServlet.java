package ch02.se07.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch02.se07.dao.DbDao;

@WebServlet(name="login", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 8846658227107830824L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errMsg = "";

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		DbDao dao = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/crazyjee", "root", "123456");
		try (Connection conn = dao.getConn()) {
			ResultSet rs = dao.query("select * from user_inf where name=?", username);
			if (rs.next()) {
				if (rs.getString("pass").equals(password)) {
					HttpSession session = req.getSession();
					// 设置session属性，跟踪用户会话状态
					session.setAttribute("name", username);
					// 请求转发
					req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
				} else {
					errMsg = "用户名和密码不匹配！";
				}
			} else {
				errMsg = "没有这个用户！";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(errMsg != null && !errMsg.equals("")) {
			req.setAttribute("err", errMsg);
			// 用户名密码输入有误，重新跳到登录页面
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
