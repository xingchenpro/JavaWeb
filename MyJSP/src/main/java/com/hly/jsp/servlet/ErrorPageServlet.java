package com.hly.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/22
 */

@WebServlet("/ErrorPage")
public class ErrorPageServlet extends HttpServlet{

    public  void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        doGet(request,response);
    }

    public  void  doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("error","错误了");
        getServletContext().getRequestDispatcher("/servlet/ErrorPage.jsp").forward(request, response);



    }
}
