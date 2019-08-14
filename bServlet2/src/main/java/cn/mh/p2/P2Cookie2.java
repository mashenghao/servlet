package cn.mh.p2;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试cookie的setPath设置，<br>
 * 当前servlet的访问路径是 /cookie/P2Cookie2 --默认的cookie作用范围是/cookie/下 <br>
 * P2Cookie的访问路径是/P2Cookie ---默认的请求头携带的是 /项目名 <br>
 * 所以： 当浏览器中同时存在两个cookie，访问/cookie/P2Cookie2时，请求时携带者两个cookie，
 * 但是请求/P2cookie时，只有一个cookie，/cookie/P2Cookie2不携带
 * 
 *
 * @author mahao
 * @date 2019年4月2日 下午9:34:27
 */
public class P2Cookie2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie2 = new Cookie("P2Cookie2", new Date().toString());
		cookie2.setPath("/bServlet2/cookie/P2Cookie2");
		cookie2.setMaxAge(0);//设置cookie存活时间是0，就是立即删除
		//设置某些删除某些路径下的cookie，告诉浏览器当前cookie要作用于/bservlet下的cookie
		cookie2.setPath("/");
		response.addCookie(cookie2);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}