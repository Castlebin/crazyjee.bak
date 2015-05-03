package ch02.se12;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/async"}, asyncSupported=true)
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = -8068501950374923593L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<title>异步调用示例</title>");
		out.print("进入Servlet的时间：" + new Date()+"<br>");
		
		// 创建AsyncContext，开始异步调用
		AsyncContext actx = request.startAsync();
		actx.addListener(new MyAsyncListener());
		// 设置异步调用的超时时常
		actx.setTimeout(60 * 1000);
		// 启动异步调用的线程
		actx.start(new GetBooksTarget(actx));
		
		out.print("结束Servlet的时间：" + new Date());
	}

}
