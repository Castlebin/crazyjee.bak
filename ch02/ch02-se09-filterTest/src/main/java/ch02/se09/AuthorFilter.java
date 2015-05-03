package ch02.se09;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "authority", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8"),
		@WebInitParam(name = "loginPage", value = "/login.jsp"),
		@WebInitParam(name = "proLogin", value = "/proLogin.jsp") })
public class AuthorFilter implements Filter {
	private FilterConfig config;

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//  获取Filter的配置参数
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("loginPage");
		String proLogin = config.getInitParameter("proLogin");
		
		// 设置request所用的编码集，从而可以对request内容进行正确的解码
		request.setCharacterEncoding(encoding);
		
		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpSession session = hRequest.getSession();
		// 获取用户请求的页面
		String requestPath = hRequest.getServletPath();
		// 如果session范围内的user为null，则表示用户没有登录
		// 且用户当前既不是在登录页面，也不是再登录预处理的页面
		if(session.getAttribute("user") == null
				&& !requestPath.endsWith(loginPage)
				&& !requestPath.endsWith(proLogin)) {
			// forward到登录页面
			request.setAttribute("tip", "对不起，您还没有登录");
			request.getRequestDispatcher(loginPage).forward(request, response);
		} else {
			// 权限验证通过，放行
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		this.config = null;
	}

}
