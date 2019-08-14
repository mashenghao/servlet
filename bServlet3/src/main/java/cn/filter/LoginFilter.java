package cn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器拦截请求实现自动登录操作
 *
 * @author mahao
 * @date 2019年4月23日 下午7:43:54
 */
public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println(req.getSession().getAttribute("user"));
		/*
		 * 1.是否已经登录：
		 * 		放行
		 * 2.没有登录：
		 * 	是否是在请求登录
		 * 		cookie存在
		 * 		存在： 利用cookie登录
		 * 		不存在：登录页面
		 */
		
		String user = (String) req.getSession().getAttribute("user");
		if(user!=null) {
			chain.doFilter(req, resp);
		}else {
			String uri = req.getRequestURI();
			if(uri.endsWith("login.do")||uri.endsWith("login.html")) {
				chain.doFilter(req, resp);
				return ;
			}
			
			Cookie cookie = CookieUtil.getCookie(req.getCookies(), "user");
			if(cookie==null) {
				resp.sendRedirect("/bServlet3/login.html");
			}else {
				String val = cookie.getValue();
				if("admin-123456".equals(val)) {
					req.getSession().setAttribute("user","admin-123456");
					chain.doFilter(req, resp);
				}else {
					resp.sendRedirect("/bServlet3/login.html");
				}
			}
		}
	}

	public void destroy() {

	}

}
