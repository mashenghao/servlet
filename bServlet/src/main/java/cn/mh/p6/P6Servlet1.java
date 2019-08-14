package cn.mh.p6;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取客户机信息
 *
 * @author mahao
 * @date: 2019年3月30日 下午8:28:08
 */
public class P6Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.setOut(new PrintStream(response.getOutputStream()));
		
		String ip = request.getRemoteAddr();
		System.out.println("<br>ip地址是：  " + ip);
		String method = request.getMethod();
		System.out.println("<br>请求方式是：   " + method);
		String contextPath = request.getContextPath();
		System.out.println("<br>获取虚拟路径  "+contextPath);
		StringBuffer url = request.getRequestURL();
		System.out.println("<br>获取请求完整url   "+url);
		String uri = request.getRequestURI();
		System.out.println("<br>获取请求资源uri   "+uri);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}