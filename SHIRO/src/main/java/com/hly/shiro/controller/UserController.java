package com.hly.shiro.controller;

import com.hly.shiro.entity.User;
import com.hly.shiro.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/30
 */
@Controller
@RequestMapping("/")
public class UserController {


    /**
     * 验证登录
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String login (User user, HttpServletRequest request){
        //安全验证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserId(), CryptographyUtil.md5(user.getUserPassword(),user.getUserId()));
        try {
            subject.login(token);
            return "/index.jsp";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            request.setAttribute("error","用户名或密码错误!");
            return "/login.jsp";
        }
    }
}
