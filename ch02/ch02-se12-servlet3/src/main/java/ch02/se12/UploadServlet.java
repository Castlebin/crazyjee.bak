package ch02.se12;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns={"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = -1830435699079858345L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 获取普通请求参数
		String name = request.getParameter("name");
		out.print("name: " + name);
		
		// 获取文件上传域
		Part part = request.getPart("file");
		// 上传文件的类型为：
		out.print("上传文件的类型为：" + part.getContentType()+"<br>");
		// 大小
		out.print("上传文件的大小为：" + part.getSize()+"<br>");
		
		// 获取该文件上传域的HeaderNames
		Collection<String> headerNames = part.getHeaderNames();
		for(String headerName : headerNames) {
			out.print(headerName + " ---> " + part.getHeader(headerName) +"<br>");
		}
		
		out.print("part.getName()： "+ part.getName() +"<br>");
		
		// 获取包含原始文件名的字符串
		String fileNameInfo = part.getHeader("content-disposition");
		// 提取上传文件的原始文件名
		String fileName = fileNameInfo.substring(
			fileNameInfo.indexOf("filename=\"") + 10 , fileNameInfo.length() - 1);
		// 将上传的文件写入服务器
		part.write(getServletContext().getRealPath("/uploadFiles")
			+ "/" + fileName );               // ①
	}

}
