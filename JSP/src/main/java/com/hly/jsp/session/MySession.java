package com.hly.jsp.session;

import org.apache.shiro.session.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/18
 */
@WebServlet("/MySession")
public class MySession  extends HttpServlet{

    private static  int visitNum =0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //不存在则创建session对象
        HttpSession session = request.getSession(true);
        //session创建时间
        Date createTime = new Date(session.getCreationTime());
        //网页被访问的最后时间
        Date lastTime = new Date(session.getLastAccessedTime());
        Integer visitNum = 0;

        if(session.isNew()){
            session.setAttribute("visitNum",visitNum);
            session.setAttribute("userId","hly");
        }
        else{
            visitNum = (Integer) session.getAttribute("visitNum");
            /*语句需要放在一开始运行的网页，不然会出现空指针报错*/
            visitNum+=1;
            session.setAttribute("visitNum",visitNum);
        }

        getServletContext().getRequestDispatcher("/session/session.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
