package cn.mh.p1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试Servlet启动自动加载<br>
 * 当服务器启动完毕后，对某些Servlet需要预先加载， 
 * 加载消耗时间较长的资源，可以提高第一次访问速度
 *
 * @author mahao
 * @date: 2019年3月28日 下午7:29:25
 */
public class Servlet5 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Servlet的init方法被加载-----");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("hello haohao...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}