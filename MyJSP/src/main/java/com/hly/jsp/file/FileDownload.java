package com.hly.jsp.file;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/22
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) {


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }


}
