package com.hly.jsp.javaWeb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2018/12/24
 */
@WebFilter(filterName = "encodingFilter", value = {"/*"})
public class EncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException { }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("编码转换");
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
    public void destroy() { }
}

