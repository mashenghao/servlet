package cn.listener.p2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContextAttributeListener的监听器规则
 *
 * @author mahao
 * @date 2019年4月22日 下午9:15:14
 */
public class ListenerServlet extends HttpServlet {

	int i = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletConfig().getServletContext();
		context.setAttribute("num", "" + i++);
		response.getWriter().write((String) context.getAttribute("num"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}