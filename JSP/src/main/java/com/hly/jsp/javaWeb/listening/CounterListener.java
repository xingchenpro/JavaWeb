package com.hly.jsp.javaWeb.listening;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class CounterListener implements HttpSessionListener {
	private static long onlineNumber = 0;
	public static long getOnlineNumber() {
		return onlineNumber;
	}
	public void sessionCreated(HttpSessionEvent se) {
		onlineNumber++;
	}
	public void sessionDestroyed(HttpSessionEvent se) {
		onlineNumber--;
	}
}
