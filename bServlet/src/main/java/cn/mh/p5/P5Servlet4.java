package cn.mh.p5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面上输出中文问题
 *
 * @author mahao
 * @date: 2019年3月30日 下午2:58:17
 */
public class P5Servlet4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out2(response);
	}

	/**
	 * 字节流形式 <br>
	 * 不一定乱码：如果服务端编码的形式和浏览器端解码的形式是一样的，则不会出现乱码<br>
	 * 解决方法：服务端和客户端指定相同的编码，设置Content-Type告诉；浏览器解码形式
	 * 
	 * @throws IOException
	 */
	public void out1(HttpServletResponse response) throws IOException {
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		ServletOutputStream out = response.getOutputStream();
		out.write("字节流".getBytes());
	}

	/**
	 * 字符流形式 <br>
	 * 一定乱码：因为服务端的字符流缓冲区采用是iso8859-1，不支持中文，<be>
	 * 解决方法：设定字符缓冲区编码，通知浏览器编码格式
	 * @throws IOException
	 */
	public void out2(HttpServletResponse response) throws IOException {
		String encoding1 = response.getCharacterEncoding();
		response.setCharacterEncoding("utf-8");//设置缓冲区编码
		String encoding2 = response.getCharacterEncoding();
		System.out.println(encoding1+"---"+encoding2);
		response.setHeader("Content-Type", "text/html;charset=utf-8");//设置浏览器端编码
		//简写为
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		writer.write("字符流");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}