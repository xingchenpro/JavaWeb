package com.hly.jsp.javaWeb.listening;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("��ǰwebӦ�ùر��ˣ�");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("��ǰwebӦ�������ˣ�");
	}
	
}
