package cn.mh.p2.demo;

public class MainClass {

	public static void main(String[] args) {
		MyThread t1 =new MyThread("线程1");
		t1.start();
		MyThread t2 =new MyThread("线程2");
		t2.start();
		MyThread t3 =new MyThread("线程3");
		t3.start();
	}


}
