package com.hly.jsp.javaWeb.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hly
 * @blog:https://blog.csdn.net/Sirius_hly
 * @github:https://github.com/SiriusHly
 * @date 2018年12月24日 下午6:38:03
 */
@WebFilter(filterName = "myFilter",
//当过滤器的目标资源有多个时，可以使用value的标准形式如下,value等价于urlPatterns：
	value = {"/javaWeb/exp_10/index.jsp","/javaWeb/exp_10/another.jsp","/javaWeb/exp_10/form.jsp"},
	// 当过滤器的目标资源只有一个时，可以使用value的简写形式如下：
	//value= "/index.jsp",
//urlPatterns={"/exp_10/index.jsp","/exp_10/another.jsp"},
	dispatcherTypes = { 
		  DispatcherType.REQUEST }
)
public class MyFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("调用chain.doFilter(request, response)之前..");
		HttpServletRequest req = (HttpServletRequest) request;
		req.setAttribute("str", "a String");
		chain.doFilter(request, response);
		HttpServletResponse res = (HttpServletResponse) response;
		//res.setHeader("refresh", "3");//刷新时间间隔
		System.out.println("调用chain.doFilter(request, response)之后..");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	

}

