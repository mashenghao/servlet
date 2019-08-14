package cn.mh.p3;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ServletConfig 对象--用于读取配置文件信息
 *
 * @author mahao
 * @date 2019年3月29日 上午11:19:25
 */
public class ServletConfigDemo implements Servlet {

	ServletConfig servletConfig;

	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
	}

	public ServletConfig getServletConfig() {

		return servletConfig;
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String val = servletConfig.getInitParameter("username");
		System.out.println("单独获取一个参数值： "+val);
		
		Enumeration<String> enumeration = servletConfig.getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			System.out.println(name + ":" + servletConfig.getInitParameter(name));
		}
		ServletContext servletContext = servletConfig.getServletContext();
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println("访问成功************");
	}

	public String getServletInfo() {
		return null;
	}

	public void destroy() {

	}

}
