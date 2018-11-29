package com.hly.jsp.javaWeb.controller;

import com.hly.jsp.javaWeb.dao.EmployeeDao;
import com.hly.jsp.javaWeb.entity.Employee;
import com.hly.jsp.javaWeb.impl.EmployeeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/28
 */

@WebServlet(urlPatterns = { "*.do" })
public class EmployeeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        String url = request.getRequestURI();
        String methodName = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
        Method method = null;
        try {
            // 使用反射机制获取在本类中声明了的方法
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            throw new RuntimeException("调用方法出错！");
        }
    }

    //具体方法

    public void addEmp(HttpServletRequest request, HttpServletResponse response) {


    }

    public void selectAllEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        List<Employee> list = employeeDao.selectAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/javaWeb/manage/main.jsp").forward(request, response);

    }

    public void selectByEmpName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("selectName");
        System.err.println("name"+name);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        List<Employee> list = employeeDao.query(name);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/javaWeb/manage/main.jsp").forward(request, response);

    }

    public void updateEmp(HttpServletRequest request, HttpServletResponse response) {

    }

    public void deleteEmp(HttpServletRequest request, HttpServletResponse response) {

    }

}
