package com.hly.jsp.cookie;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println(user+" "+password);
        Cookie cookie = new Cookie("message","message");
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        PrintWriter out = response.getWriter();
        out.print("success");


    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doGet(request,response);
    }


}
