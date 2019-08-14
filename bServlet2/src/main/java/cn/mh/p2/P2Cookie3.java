package cn.mh.p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie应用，浏览记录
 *
 * @author mahao
 * @date 2019年4月9日 下午9:02:51
 */
public class P2Cookie3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		Cookie cookie = CookieUtil.getCookie(request.getCookies(), "items");
		if (cookie == null) {
			cookie = new Cookie("items", no);
			cookie.setMaxAge(10);
			cookie.setPath("/bServlet2");
		} else {
			String val = cookie.getValue();
			String[] nos = val.split(",");

			boolean exist = false;
			for (int i = 0; i < nos.length; i++) {
				if (nos[i].equals(no)) {
					exist = true;
					break;
				}
			}
			if (!exist) {
				cookie.setValue(no + "," + val);
				cookie.setMaxAge(10);
			}
		}
		response.addCookie(cookie);
		response.sendRedirect("/bServlet2/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}