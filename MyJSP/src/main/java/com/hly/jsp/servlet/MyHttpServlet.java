package com.hly.jsp.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/17
 */

@WebServlet(value = "/MyHttpServlet")
public class MyHttpServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //相应内容类型
        System.out.println("ServletFilter过滤器");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("123");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

}
