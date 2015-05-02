package ch02.se06.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="get-application", urlPatterns={"/get-application"})
public class GetApplication extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext application = getServletContext();
		PrintWriter out = resp.getWriter();
		
		out.print(application.getAttribute("counter"));
		
	}
	
	
		
}
