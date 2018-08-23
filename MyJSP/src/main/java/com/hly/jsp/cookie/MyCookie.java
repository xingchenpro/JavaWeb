package com.hly.jsp.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/18
 */
@WebServlet("/MyCookie")
public class MyCookie extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String userId = request.getParameter("userId");
        String userPassword = request.getParameter("userPassword");
        System.out.println(userId+" "+userPassword);
        /*创建cookie对象*/
        Cookie  id= new Cookie("id",userId);
        Cookie password = new Cookie("pw",userPassword);
        id.setMaxAge(60);
        password.setMaxAge(60);
       /*添加cookie*/
        response.addCookie(id);
        response.addCookie(password);
        PrintWriter out = response.getWriter();
        out.println("success");
        getServletContext().getRequestDispatcher("/cookie/cookie.jsp").forward(request,response);

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }


}
