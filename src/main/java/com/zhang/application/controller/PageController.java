package com.zhang.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 21:18 2020/3/3
 */
@Controller
public class PageController {
    //求职者登录注册
    @GetMapping("/applicantReg")
    public String applicantReg(){
        return "applicantReg";
    }
    @GetMapping("/applicantLog")
    public String applicantLog(){
        return "applicantLog";
    }
    //推荐者登录注册
    @GetMapping("/staffLog")
    public String staffLog(){
        return "staffLog";
    }
    @GetMapping("/staffReg")
    public String staffReg(){
        return "staffReg";
    }
    //HR登录通道
    @GetMapping("/hrLog")
    public String hrLog(){
        return "hrLog";
    }
    //管理员登录通道
    @GetMapping("/adminLog")
    public String adminLog(){
        return "adminLog";
    }


    @GetMapping("/")
    public String index(){
        return "index";
    }

}
