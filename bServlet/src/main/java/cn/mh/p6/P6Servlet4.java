package cn.mh.p6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 转发与重定向
 *
 * @author mahao
 * @date: 2019年3月31日 下午2:40:17
 */
public class P6Servlet4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dispatcher(request,response);
		redirect(request,response);
	}

	// 转发--转发到/servlet1.do上
	public void dispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/servlet1.do").forward(request, response);
	}

	// 重定向--定向到/servlet1.do上
	public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("/bServlet/servlet1.do");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}