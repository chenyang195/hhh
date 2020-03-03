package com.zhang.application.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 21:18 2020/3/3
 */
@Controller
public class UserController {
    @RequestMapping("/applicantRegin")
    public String applicantRegin (HttpServletRequest request){

        System.out.println(request.getParameter("phoneNum"));
        System.out.println(request.getParameter("code"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("password2"));
        System.out.println(request.getParameter("staffNum"));
        return "applicantLog";
    }
    @RequestMapping("/applicantLogin")
    public String applicantLogin (HttpServletRequest request){
        if (request.getParameter("code").equals("123456")){
            if(request.getParameter("phoneNum").equals("15812345678")){
                if (request.getParameter("password").equals("147258369")){
                    return "question";
                }
            }
        }
        return "applicantLog";

    }
}
