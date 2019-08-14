package cn.mh.p7;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试servlet的映射/* 和 / 的区别；
 * 
 *  /   :  不拦截*.jsp，这个是拦截了servlet请求，还有静态请求，相当于替换了默认的servlet
 *  /*  :  替换掉了所有的servlet的路径，这个会拦截到所有的请求，包括静态和servlet
 *  
 *  相同：
 *  	两者是拦截所有的系统不存在的请求，如果存在完全匹配，或者目录匹配的Servlet，则会优先匹配他们。
 *	如果不存在，则会被/* 或者 /拦截请求。对于框架而言，如springmvc，整个springmvc框架只有一个servlet，所以配置成
 *  / 或者 /* 都可以被中央处理器拦截到，不同的就是他们之间的区别。
 *  
 * @author XXX
 * @date 2019年5月8日 下午6:31:14
 */
public class PathServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("hello haohao...PathServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}