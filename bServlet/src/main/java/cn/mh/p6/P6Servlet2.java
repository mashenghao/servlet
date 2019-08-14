package cn.mh.p6;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取请求头信息
 *
 * @author  mahao
 * @date:  2019年3月30日 下午8:45:49
 */
public class P6Servlet2 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> names = req.getHeaderNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name+"---------"+req.getHeader(name));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}