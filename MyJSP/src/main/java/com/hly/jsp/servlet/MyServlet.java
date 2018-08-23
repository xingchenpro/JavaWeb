package com.hly.jsp.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/21
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    public  void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        doGet(request,response);
    }

    public  void  doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        //定时刷新
        //response.setIntHeader("Refresh",1);
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(date);
        PrintWriter out = response.getWriter();
        out.println(nowTime);
        //获取响应头信息
        System.out.println("响应头信息:");

        //获取http请求头信息
        System.out.println("请求头信息:");
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String paraName = (String)headerNames.nextElement();
            System.out.print(paraName+":");
            String paraVlue = request.getHeader(paraName);
            System.out.println(paraVlue);
        }
    }
    /**
     * 第一次创建时执行，执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        System.out.println("初始化");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /**
     * 客户端的响应，每次请求执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行");
        doGet(servletRequest,servletResponse);
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    //销毁方法
    @Override
    public void destroy() {

    }




}
