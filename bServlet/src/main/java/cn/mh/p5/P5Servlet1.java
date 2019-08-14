package cn.mh.p5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 根据http响应头location 和302状态码，完成浏览器重定向
 *
 * @author mahao
 * @date: 2019年3月29日 下午5:31:45
 */
public class P5Servlet1 extends HttpServlet {

	//重定向是服务端将重定向地址写会客户端，在客户端完成页面跳转，因此写的地址是客户端形式的地址
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//方式一： 手动设置头
		//response.setStatus(302);
		//response.setHeader("Location", "/bServlet/servlet1.do");
		//方式二： 
		response.sendRedirect("./servlet2.do");
		response.getWriter().write("hello haohao...");
		
		response.setHeader("refresh", "5;url=/bservlet/servlet1.do");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
