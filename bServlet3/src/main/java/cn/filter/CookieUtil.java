package cn.filter;

import javax.servlet.http.Cookie;

public class CookieUtil {

	/**
	 * 根据指定名称获取cookie
	 * 
	 * @param cookies
	 * @param name
	 * @return cookie 或者 null
	 */
	public static Cookie getCookie(Cookie[] cookies, String name) {
		if (cookies == null) {
			return null;
		} else {
			for (Cookie c : cookies) {
				System.out.println(c.getName()+"-*---"+c.getValue());
				if (name.equals(c.getName())) {
					return c;
				}
			}
			return null;
		}
	}
}
