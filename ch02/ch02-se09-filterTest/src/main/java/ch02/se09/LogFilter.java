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
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="logFilter", urlPatterns={"/*"})
public class LogFilter implements Filter {
	private FilterConfig config;

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 下面代码用于对用户的请求执行预处理
		ServletContext context = this.config.getServletContext();
		long before = System.currentTimeMillis();
		System.out.println("开始过滤…");
		// 将请求转化为HttpServletRequest
		HttpServletRequest hRequest = (HttpServletRequest)request;
		// 输出提示信息
		System.out.println("Filter截获到用户的请求地址：" + hRequest.getServletPath());

		// 请求依然放行到目的地址
		chain.doFilter(request, response);
		
		// 后处理
		long after = System.currentTimeMillis();
		// 输出提示信息
		System.out.println("日志处理结束");
		System.out.println("请求被定位到：" + hRequest.getRequestURL()+", 所花时间为：" + (after - before) + "mills");
	}

	public void destroy() {
		this.config = null;
	}

}
