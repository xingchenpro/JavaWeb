package com.hly.jsp.session;

import org.apache.shiro.session.Session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/18
 */
@WebServlet("/MySession")
public class MySession  extends HttpServlet{

    private static  int visitNum =0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        /*1.Session值如何后台获取*/
        /*2.后台如何返值显示到前台*/




    }
}
