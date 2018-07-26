package com.hly.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @date :2018/6/21
 */
@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        return mv;
    }

}
