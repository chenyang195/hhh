package com.zhang.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 21:18 2020/3/3
 */
@Controller
public class PageController {
    //求职者登录注册
    @RequestMapping("/applicantReg")
    public String applicantReg(){
        return "applicantReg";
    }
    @RequestMapping("/applicantLog")
    public String applicantLog(){
        return "applicantLog";
    }
    //推荐者登录注册
    @RequestMapping("/staffLog")
    public String staffLog(){
        return "staffLog";
    }
    @RequestMapping("/staffReg")
    public String staffReg(){
        return "staffReg";
    }
    //HR登录通道
    @RequestMapping("/hrLog")
    public String hrLog(){
        return "hrLog";
    }
    //管理员登录通道
    @RequestMapping("/adminLog")
    public String adminLog(){
        return "adminLog";
    }


    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
