package com.hly.jsp.javaWeb.listening;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextAttributeListener
 *
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
         System.out.println("添加属性名"+ arg0.getName());
         System.out.println("添加属性值"+ arg0.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
    	System.out.println("替换属性名"+ arg0.getName());
        System.out.println("替换属性值"+ arg0.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
    	System.out.println("删除属性名"+ arg0.getName() + ";删除属性值" + arg0.getValue());
    }
	
}
