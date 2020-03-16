package com.zhang.application.service.authorService;

import com.zhang.application.Entity.AdminInfo;
import com.zhang.application.Entity.ApplicantInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:50 2020/3/14
 */
public interface AdminService {
    public Integer addAdmin(AdminInfo adminInfo);
    public String adminLogin(HttpServletRequest request);
    public String adminRegin(HttpServletRequest request);
}
