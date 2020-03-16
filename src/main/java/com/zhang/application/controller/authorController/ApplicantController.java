package com.zhang.application.controller.authorController;

import com.zhang.application.pojo.Answer;
import com.zhang.application.mapper.AnswerMapper;
import com.zhang.application.service.authorService.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author : zhang
 * @Description :
 * @Date: Created in 22:03 2020/3/1
 */

@Controller
public class ApplicantController {

    @Autowired
    ApplicantService applicantService;


    @PostMapping("/applicantReg")
    public String applicantRegin(HttpServletRequest request) {
       String result = applicantService.applicantRegin(request);
       return result;
    }

    @PostMapping("/applicantLog")
    public String applicantLogin(HttpServletRequest request) {
        String result = applicantService.applicantLogin(request);
        return result;
    }
}
