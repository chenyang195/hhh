package com.zhang.application.service.authorService;

import com.zhang.application.Entity.ApplicantInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 14:42 2020/3/8
 */
public interface ApplicantService {
    public Integer addApplicant(ApplicantInfo applicantInfo);
    public String applicantLogin(HttpServletRequest request);
    public String applicantRegin(HttpServletRequest request);
}
