package com.hly.jsp.javaWeb.listening;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionBindingListener
 *
 */
@WebListener
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionBindingListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
