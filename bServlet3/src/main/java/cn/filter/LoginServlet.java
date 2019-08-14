package cn.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录操作
 *
 * @author mahao
 * @date 2019年4月23日 下午7:53:52
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String autoLogin = request.getParameter("autoLogin");
		/*
		 * 登录成功: 1.存取session 2.写会cookie 3.跳转主页面
		 */
		if ("admin".equals(name) && "123456".equals(pwd)) {
			request.getSession().setAttribute("user", "admin-123456");

			if ("on".equals(autoLogin)) {
				Cookie cookie = new Cookie("user", "admin-123456");
				cookie.setMaxAge(60 * 24 * 7);
				response.addCookie(cookie);
			}

			response.sendRedirect("/bServlet3/main.html");
		} else {
			// 登录失败： 回到登录页面
			response.sendRedirect("/bServlet3/login.html");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
