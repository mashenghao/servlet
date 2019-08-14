package cn.filter.p3;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 使用jdk的动态代理来增强HttpServletRequest类的getParatrooper方法
 *
 * @author mahao
 * @date 2019年4月24日 下午9:29:10
 */
public class CodeFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest req = (HttpServletRequest) request;

		HttpServletRequest proxyReq = (HttpServletRequest) Proxy.newProxyInstance(CodeFilter.class.getClassLoader(),
				req.getClass().getInterfaces(), new InvocationHandler() {

					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("创建代理服务执行-------" + method.getName());
						if ("getParameter".equals(method.getName())) {// 对获取值的方法进行增强
							System.out.println("曾强方法");
							String method2 = req.getMethod();
							if ("post".equalsIgnoreCase(method2)) {
								req.setCharacterEncoding("utf-8");
								return method.invoke(req, args);
							} else {
								String v = (String) method.invoke(req, args);
								return v;
							}
						}
						return method.invoke(req, args);
					}
				});

		chain.doFilter(proxyReq, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
