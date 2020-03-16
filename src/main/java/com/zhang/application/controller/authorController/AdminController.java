package com.zhang.application.controller.authorController;

import com.zhang.application.service.authorService.AdminService;
import com.zhang.application.service.authorService.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 22:02 2020/3/14
 */
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;


    @PostMapping("/adminReg")
    public String applicantRegin(HttpServletRequest request) {
        String result = adminService.adminRegin(request);
        return result;
    }

    @PostMapping("/adminLog")
    public String applicantLogin(HttpServletRequest request) {
        String result = adminService.adminLogin(request);
        return result;
    }
}
