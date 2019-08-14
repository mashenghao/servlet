package cn.listener.p1;

import java.util.ArrayList;
import java.util.List;

public class MyButton {
	
	List<Listener> listened = new ArrayList<Listener>();//监听器们

	public void addClickListener(Listener l) {
		l.click(new ClickEvent(this));
		listened.add(l);
	}

	public void click() {
		System.out.println("触发按钮点击操作----");
		this.executeListened();
	}

	private void executeListened() {
		for(Listener l: listened) {
			//l.click();
		}
	}
}
