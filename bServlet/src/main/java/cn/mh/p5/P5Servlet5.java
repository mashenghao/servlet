package cn.mh.p5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载 ： Content-Disposition attachment；filename=filename
 *
 * @author mahao
 * @date 2019年3月30日 下午4:10:36
 */
public class P5Servlet5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Disposition", "attachment;filename=aa.txt");
		// 通过servlet上下文加载资源
		InputStream in = getServletContext().getResourceAsStream("/file/中文标题.txt");
		copy(in, response.getOutputStream());// 文件复制
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void copy(InputStream in, OutputStream out) throws IOException {
		byte[] buf = new byte[1024];
		int len = -1;
		while ((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}
}