package cn.listener.p2;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements  ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("add-------"+event.getName());
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Removed-------"+event.getName());
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Replaced-------"+event.getName());
	}

	
}
