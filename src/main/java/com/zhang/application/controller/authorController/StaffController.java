package com.zhang.application.controller.authorController;

import com.zhang.application.service.authorService.AdminService;
import com.zhang.application.service.authorService.StaffService;
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
public class StaffController {
    @Autowired
    StaffService staffService;


    @PostMapping("/staffReg")
    public String applicantRegin(HttpServletRequest request) {
        String result = staffService.staffRegin(request);
        return result;
    }

    @PostMapping("/staffLog")
    public String applicantLogin(HttpServletRequest request) {
        String result = staffService.staffLogin(request);
        return result;
    }
}
