package ch02.se12;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;

public class GetBooksTarget implements Runnable {
	private AsyncContext actx;
	
	public GetBooksTarget(AsyncContext actx) {
		this.actx = actx;
	}

	@Override
	public void run() {
		try {
			// 等待5秒，模拟业务方法执行耗时
			Thread.sleep(5 * 1000);
			
			ServletRequest request = actx.getRequest();
			List<String> books = new ArrayList<>();
			books.add("疯狂Java讲义");
			books.add("疯狂Android讲义");
			books.add("疯狂yingyu");
			
			request.setAttribute("books", books);
			actx.dispatch("/async.jsp");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
