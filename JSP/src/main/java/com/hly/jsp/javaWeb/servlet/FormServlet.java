package com.hly.jsp.javaWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hly
 * @blog:www.javahly.com
 * @github:https://github.com/SiriusHly
 * @date 2018年12月24日 下午7:39:25
 */
@WebServlet("/Form")
public class FormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// 在控制台打印输出注册信息
		System.out.println("name=" + name + ";password=" + password);
	}
}

