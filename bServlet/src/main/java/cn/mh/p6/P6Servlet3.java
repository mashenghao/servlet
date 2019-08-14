package cn.mh.p6;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取请求参数
 *
 * @author mahao
 * @date: 2019年3月30日 下午8:55:56
 */
public class P6Servlet3 extends HttpServlet {

	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求乱码问题--get
		
		System.out.println(request);
		// 1.获取input单个数据
		String name = request.getParameter("username");
		String encode = URLEncoder.encode(name,"iso-8859-1");
		String name2 = URLDecoder.decode(encode,"utf-8");
		System.out.println(name2);
		//相同
		String name3 = new String(name.getBytes("iso-8859-1"),"utf-8");
		// 2.获取爱好多个数据
		String[] loves = request.getParameterValues("love");
		// 3.通过getParameterMap获取数据
		Map<String, String[]> parameterMap = request.getParameterMap();
		request.getRequestDispatcher("/").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
