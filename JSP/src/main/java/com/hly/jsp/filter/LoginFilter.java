package com.hly.jsp.filter;
import javax.servlet.*;
import java.io.IOException;
/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/17
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig){
        /*获得初始化参数*/
        String user = filterConfig.getInitParameter("user");
        System.out.println("用户名:"+user);
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        String userId  = request.getParameter("userId");
        String password = request.getParameter("password");
        if(userId.equals("hly")&&password.equals("123")){
            System.out.println("验证成功");
            System.out.println("请求传回过滤链");
            filterChain.doFilter(request,response);
        }else {
            System.out.println("验证失败");
        }
    }
    public void destroy(){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}
