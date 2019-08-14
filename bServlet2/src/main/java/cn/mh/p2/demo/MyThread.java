package cn.mh.p2.demo;

public class MyThread extends Thread {
	
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	public void run() {
		MyServlet myServlet = MyServlet.getInstance();
		myServlet.service(name);
	};
}