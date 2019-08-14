package cn.mh.p2.demo;

/**
 * 采用单例设计模式，成员变量会存在并发问题，这个是模仿
 * servlet的设计方式。servlet在第一次被访问时，创建实例，
 * 之后实例就常驻内存。成员变量存在并发问题；
 *
 * @author mahao
 * @date 2019年4月13日 下午8:29:20
 */
public class MyServlet {

	private static MyServlet myServlet = null;

	private MyServlet() {

	};

	public static MyServlet getInstance() {
		if (myServlet == null) {
			synchronized (MyServlet.class) {
				if (myServlet == null) {
					myServlet = new MyServlet();
				}
			}
		}
		return myServlet;
	}

	int n = 0;

	public void service(String name) {

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			System.out.println(name + "--" + n++);
		}
	}
}
