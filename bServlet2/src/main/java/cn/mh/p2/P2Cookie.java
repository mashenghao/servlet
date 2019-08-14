package cn.mh.p2;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie:记录上次访问时间
 *
 * @author mahao
 * @date: 2019年4月1日 下午2:54:25
 */
public class P2Cookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtil.getCookie(cookies, "LAST_REQUEST_TIME");
		if (cookie == null) {
			response.getWriter().write("<h2>第一次访问</h2>");
		} else {
			response.getWriter().write("<h2>多次访问</h2>" + cookie.getValue());
		}
		// 1.手动设置cookie，通过设置响应头，set-cookie ，但是cookie会存在以前的丢失。使用cookie对象那个的api可以解决
		response.setHeader("set-cookie", "mycookie=snlkghwg");
		Cookie cookie2 = new Cookie("LAST_REQUEST_TIME", new Date().toString());
		//2. 设置cookie的有效时间，将cookie的有效时间从默认的会话更改成一个小时，单位（秒）；
		cookie2.setMaxAge(60 * 60);
		
		
		// 补加cookie
		response.addCookie(cookie2);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}