package cn.mh.p1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet的实现要实现Servlet接口
 *
 * @author mahao
 * @date: 2019年3月27日 下午6:26:55
 */
public class Servlet1 implements Servlet {

	/* 只执行一次，当第一次请求时，执行这个操作 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("1. init--------");
	}

	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig-----------");
		return null;
	}

	/* 多次执行，每次来请求，就有执行 */
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println(req + "----Service--------" + req.getProtocol());
		res.setContentLength(25000);
		res.setContentType("Text/htmls4;charset=UTF-8");
		res.getWriter().println("2. 你好++++");
	}

	public String getServletInfo() {
		System.out.println("getServletInfo-----");
		return null;
	}

	/* 服务器停止时，调用这个方法 */
	public void destroy() {
		System.out.println("3. destroy----------");
	}

}
