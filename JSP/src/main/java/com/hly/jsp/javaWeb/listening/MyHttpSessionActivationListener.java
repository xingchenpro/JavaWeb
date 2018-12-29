package com.hly.jsp.javaWeb.listening;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * Application Lifecycle Listener implementation class MyHttpSessionActivationListener
 *
 */
@WebListener
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
    /**
     * Default constructor. 
     */
    public MyHttpSessionActivationListener() {
        // TODO Auto-generated constructor stub
    }
	/**
     * @see HttpSessionActivationListener#sessionDidActivate(HttpSessionEvent)
     */
    public void sessionDidActivate(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	/**
     * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
     */
    public void sessionWillPassivate(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
}
