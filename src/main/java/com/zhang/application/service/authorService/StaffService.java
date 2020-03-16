package com.zhang.application.service.authorService;

import com.zhang.application.Entity.ApplicantInfo;
import com.zhang.application.Entity.StaffInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:52 2020/3/14
 */
public interface StaffService {
    public Integer addStaff(StaffInfo staffInfo);
    public String staffLogin(HttpServletRequest request);
    public String staffRegin(HttpServletRequest request);
}
