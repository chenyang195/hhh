package com.zhang.application.service.authorService.impl;

import com.zhang.application.Entity.AdminInfo;
import com.zhang.application.Entity.AdminRole;

import com.zhang.application.mapper.AdminInfoMapper;
import com.zhang.application.mapper.AdminRoleMapper;

import com.zhang.application.service.authorService.AdminService;

import com.zhang.application.utill.MD5Encrypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 20:16 2020/3/14
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminInfoMapper adminInfoMapper;
    @Resource
    AdminRoleMapper adminRoleMapper;


    //注册用户
    @Override
    public Integer addAdmin(AdminInfo adminInfo) {
        String enPassword = MD5Encrypt.encrypt(adminInfo.getPhoneNum(),adminInfo.getPassword()).toString();
        adminInfo.setPassword(enPassword);
        AdminInfo  adminInfoCkeck = adminInfoMapper.selectOne(adminInfo);
        if (adminInfoCkeck!=null){
            return -1;
        }
        adminInfoMapper.insert(adminInfo);
        Integer id =adminInfo.getId();
        //设置默认权限
        if(id>0){
            AdminRole adminRole = new AdminRole();

            int[] roleIds = {1,2,3,4,5};
            for (int roleId: roleIds) {
                adminRole.setId(null);
                adminRole.setUserId(id);
                adminRole.setRoleId(roleId);
                adminRoleMapper.insert(adminRole);
            }
        }



        return id;
    }
    //登录校验
    @Override
    public String adminLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (request.getParameter("code")==null){

            return "/adminLog";
        }
        Object localCode1 = session.getAttribute("localCode");
        if (localCode1==null){
            return "/adminLog";
        }
        String localCode = localCode1.toString();



        if(!(request.getParameter("code").equalsIgnoreCase(localCode))){

            session.setAttribute("msg","验证码错误");
            return "/adminLog";
        }
        String phoneNum = request.getParameter("phoneNum");
        if (phoneNum==null){
            session.setAttribute("msg","请输入手机号！");
            return "/adminLog";
        }else {
            AdminInfo  adminInfo = new AdminInfo();
            adminInfo.setPhoneNum(phoneNum);
            adminInfo = adminInfoMapper.selectOne(adminInfo);
            if (adminInfo==null){
                session.setAttribute("msg","手机号"+phoneNum+"未注册！");
                return "/adminLog";
            }
        }
        String password = request.getParameter("password");
        if (password==null){
            session.setAttribute("msg","请输密码！");
            return "/adminLog";
        }
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("phoneNum"),request.getParameter("password"));
        token.setRememberMe(true);



        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        //3.执行登录方法
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //System.out.println("无用户");
            session.setAttribute("msg","用户名不存在");
            return "/adminLog";
        }catch (IncorrectCredentialsException e){
            //System.out.println("密码错");
            session.setAttribute("msg","密码错误");
            return "/adminLog";
        }catch (AuthenticationException e){
            session.setAttribute("msg","登录错误");
            return "/adminLog";
        }
        if (savedRequest == null || savedRequest.getRequestUrl() == null) {

            session.setAttribute("msg","登录成功");
            return "index";


        }
        session.setAttribute("msg","登录成功");
        return "index"; /*savedRequest.getRequestUrl();*/

    }

    @Override
    public String adminRegin(HttpServletRequest request) {
        HttpSession session = request.getSession();
       /*Object localCode = request.getAttribute("localCode");
        if (localCode == null) {
            return "applicantReg";
        }
        String code = request.getParameter("code");
        if (code == null) {
            request.setAttribute("msg", "未填写验证码！");
            return "applicantReg";
        } else if (!code.equals((String) localCode)) {
            request.setAttribute("msg", "验证码不正确！");
            return "applicantReg";
        }*/
        //存手机号
        AdminInfo adminInfo = new AdminInfo();
        String phoneNum = request.getParameter("phoneNum");
        if (phoneNum == null) {
            session.setAttribute("msg", "未填写电话号码！");
            return "index";
        }
        adminInfo.setPhoneNum(phoneNum);
        //存密码
        String password = request.getParameter("password");
        if (password == null) {
            session.setAttribute("msg", "未填写密码！");
            return "index";
        }
        String password2 = request.getParameter("password2");
        if (password2 == null) {
            session.setAttribute("msg", "未再次填写密码！");
            return "index";
        }
        if (password.equals(password2)) {
            adminInfo.setPassword(password);
        }else {
            session.setAttribute("msg", "密码不一致！");
            return "index";
        }

        int result = addAdmin(adminInfo);
        if (result > 0) {
            session.setAttribute("msg", "注册成功请您登录！");
            return "index";
        }
        if (result == -1) {
            session.setAttribute("msg", "手机号已被注册！");
            return "index";
        }

        session.setAttribute("msg", "服务器繁忙！");
        return "index";
    }
}
