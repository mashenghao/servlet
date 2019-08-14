package cn.listener.p2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 监听 session的序列化与反序列化
 *
 * @author mahao
 * @date 2019年4月22日 下午9:35:14
 */
public class SessionActivation extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Bean bean = (Bean) session.getAttribute("bean");
		if (null == bean) {
			bean = new Bean();
			bean.setName("马恒");
			session.setAttribute("bean", bean);
			System.out.println("向session中存入数据了");
		} else {
			System.out.println("session中获取的数据是-----");
		}
		response.getWriter().write("hello haohao...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}