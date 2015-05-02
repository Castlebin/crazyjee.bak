package ch02.se07.servlet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.swing.Timer;

public class TimeServlet extends HttpServlet {
	private static final long serialVersionUID = -7208178514738888918L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		Timer t = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(new Date());
			}
		});
		
		t.start();
	}
	
		
}
