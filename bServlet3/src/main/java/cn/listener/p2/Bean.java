package cn.listener.p2;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 监听session的序列化与反序列化:
 * 作用：
 * 当内存中session中存在的数据过多时，对于不经常使用的数据序列化到
 * 硬盘中，当需要时，在反序列内存中
 *
 * @author mahao
 * @date 2019年4月22日 下午9:36:37
 */
public class Bean implements HttpSessionActivationListener, Serializable {

	private String name;

	// 活化
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("方法1---------");
	}

	// 钝化
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("方法二997897897/");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
