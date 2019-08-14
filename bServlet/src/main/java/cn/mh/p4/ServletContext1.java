package cn.mh.p4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

/**
 * 
 * 注意： 在web应用程序中WebRoot对应的是项目名，发布到服务器后，webRoot是虚拟目录，就会变成<br>
 * 项目名，src源码包，则是WEB-INF下的classes文件，
 * context.getResourceAsStream("/WEB-INF/classes/conf/db.properties");
 * 
 * ServletContext对象--获取应用程序的上下文信息<br>
 * 
 * 1. 获取web应用全局初始化参数 ,通常配合filter设置编码<br>
 * 2. 实现数据共享<br>
 * 3. 读取资源配置文件
 *
 * @author mahao
 * @date: 2019年3月29日 下午1:05:14
 */
public class ServletContext1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletConfig().getServletContext();
		// 都可以： ServletContext context = this.getServletConfig();
		// 作用一： 获取参数
		String encoding = context.getInitParameter("encoding");
		System.out.println("获取的字符编码是：  ---" + encoding);

		// 作用二： 数据共享
		context.setAttribute("name", "张三");
		Object name = context.getAttribute("name");// 可在其他servlet中获取
		System.out.println("共享数据name的值是" + name);

		// 作用三： 读取资源配置文件，读取cong下的db.properties文件
		// 常规方式：
		read1();
		// 上下文，class文件发布得到服务器中，放在了WEB-INF下的class文件夹中，一个包一个文件
		// 绝对路径,省略项目名称
		InputStream inputStream = context.getResourceAsStream("/WEB-INF/classes/conf/db.properties");
		pri(inputStream);
		InputStream in2 = context.getResourceAsStream("/html/db.properties");
		pri(in2);
		InputStream in3 = context.getResourceAsStream("/WEB-INF/classes/aa/db.properties");
		pri(in3);
		
		String path = context.getContextPath();
		System.out.println("获取的应用程序的路径是--"+path);//  /bServlet
		String path2 = context.getRealPath("/WEB-INF/classes/aa/db.properties");
		System.out.println(path2);
		ServletContext context2 = context.getContext("/Demo1");
		System.out.println(context2);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// web应用和java应用的目录文件不相同，web应用的文件路径是发布到服务器后为准，java是
	// 和原本路径相同，java应用数据src目录
	@Test
	public void read1() throws IOException {
		// java路径 ： InputStream in = new
		// FileInputStream("./src/main/java/conf/db.properties");

		// web路径是会将配置文件放置在tomcat的bin目录下，最好用绝对路劲
		InputStream in = new FileInputStream("D:\\Java\\workspaces\\bServlet\\src\\main\\java\\conf\\db.properties");
		pri(in);
	}

	private void pri(InputStream in) throws IOException {
		Properties pps = new Properties();
		pps.load(in);
		for (Object key : pps.keySet()) {
			System.out.println(pps.getProperty((String) key));
		}

	}
}
