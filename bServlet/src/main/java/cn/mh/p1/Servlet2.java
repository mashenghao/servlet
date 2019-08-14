package cn.mh.p1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet实现方式二： 继承GenericServlet类
 *
 * @author mahao
 * @date: 2019年3月27日 下午6:28:54
 */
public class Servlet2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("通过GenericServlet实现-----");
	}

}
