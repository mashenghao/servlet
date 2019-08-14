package cn.filter.p3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 被访问的servlet
 *
 * @author mahao
 * @date 2019年4月24日 下午8:41:54
 */
public class CodeServlet extends HttpServlet {

	public long num = 0;
	public static long num2 = 0;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		num++;num2++;
		String name1 = request.getParameter("name");
		String name2 = request.getParameter("name2");
		String name3 = request.getParameter("name3");
		String name4 = request.getParameter("name4");
		System.out.println(request.getSession().toString());
		System.out.println(this.toString()+" " + num2+"  "+num+" ------------"+name1 + " " + name2 + " " + name3 + " " + name4 + request.toString());

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
