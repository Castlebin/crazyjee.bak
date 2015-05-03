package ch02.se13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println("<title>非阻塞IO示例</title>");
		out.println("进入Servlet的时间：" + new java.util.Date() + ".<br/>");
		// 创建AsyncContext，开始异步调用
		AsyncContext context = request.startAsync();
		// 设置异步调用的超时时长
		context.setTimeout(60 * 1000);
		ServletInputStream input = request.getInputStream();
		// 为输入流注册监听器
		input.setReadListener(new MyReadListener(input, context));
		out.println("结束Servlet的时间：" + new java.util.Date() + ".<br/>");
		out.flush();
	}
}