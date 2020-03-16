package com.zhang.application.service.authorService.impl;

import com.zhang.application.Entity.AdminInfo;
import com.zhang.application.Entity.AdminRole;
import com.zhang.application.Entity.StaffInfo;
import com.zhang.application.Entity.StaffRolesInfo;
import com.zhang.application.mapper.AdminInfoMapper;
import com.zhang.application.mapper.AdminRoleMapper;
import com.zhang.application.mapper.StaffInfoMapper;
import com.zhang.application.mapper.StaffRolesInfoMapper;
import com.zhang.application.service.authorService.StaffService;
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
 * @Date: Created in 21:37 2020/3/14
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    StaffRolesInfoMapper staffRolesInfoMapper;
    @Resource
    StaffInfoMapper staffInfoMapper;
    @Override
    public Integer addStaff(StaffInfo staffInfo) {
        String enPassword = MD5Encrypt.encrypt(staffInfo.getPhoneNum(),staffInfo.getPassword()).toString();
        staffInfo.setPassword(enPassword);
        StaffInfo staffInfoCkeck = staffInfoMapper.selectOne(staffInfo);
        if (staffInfoCkeck!=null){
            return -1;
        }
        staffInfoMapper.insert(staffInfo);
        Integer id = staffInfo.getId();
        //设置默认权限
        if(id>0){
            StaffRolesInfo staffRolesInfo = new StaffRolesInfo();

            int[] roleIds = {4,5};
            for (int roleId: roleIds) {
                staffRolesInfo.setId(null);
                staffRolesInfo.setUserId(id);
                staffRolesInfo.setRoleId(roleId);
                staffRolesInfoMapper.insert(staffRolesInfo);
            }
        }



        return id;
    }

    @Override
    public String staffLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (request.getParameter("code")==null){

            return "/staffLog";
        }
        Object localCode1 = session.getAttribute("localCode");
        if (localCode1==null){
            return "/staffLog";
        }
        String localCode = localCode1.toString();



        if(!(request.getParameter("code").equalsIgnoreCase(localCode))){

            session.setAttribute("msg","验证码错误");
            return "/staffLog";
        }
        String phoneNum = request.getParameter("phoneNum");
        if (phoneNum==null){
            session.setAttribute("msg","请输入手机号！");
            return "/staffLog";
        }else {
            StaffInfo  staffInfo = new StaffInfo();
            staffInfo.setPhoneNum(phoneNum);
            staffInfo = staffInfoMapper.selectOne(staffInfo);
            if (staffInfo==null){
                session.setAttribute("msg","手机号"+phoneNum+"未注册！");
                return "/staffLog";
            }
        }
        String password = request.getParameter("password");
        if (password==null){
            session.setAttribute("msg","请输密码！");
            return "/staffLog";
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
            return "/staffLog";
        }catch (IncorrectCredentialsException e){
            //System.out.println("密码错");
            session.setAttribute("msg","密码错误");
            return "/staffLog";
        }catch (AuthenticationException e){
            session.setAttribute("msg","登录错误");
            return "/staffLog";
        }
        if (savedRequest == null || savedRequest.getRequestUrl() == null) {

            session.setAttribute("msg","登录成功");
            return "index";


        }
        session.setAttribute("msg","登录成功");
        return "index"; /*savedRequest.getRequestUrl();*/

    }

    @Override
    public String staffRegin(HttpServletRequest request) {
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
        StaffInfo staffInfo = new StaffInfo();
        String phoneNum = request.getParameter("phoneNum");
        if (phoneNum == null) {
            session.setAttribute("msg", "未填写电话号码！");
            return "staffReg";
        }
        staffInfo.setPhoneNum(phoneNum);
        //存密码
        String password = request.getParameter("password");
        if (password == null) {
            session.setAttribute("msg", "未填写密码！");
            return "staffReg";
        }
        String password2 = request.getParameter("password2");
        if (password2 == null) {
            session.setAttribute("msg", "未再次填写密码！");
            return "staffReg";
        }
        if (password.equals(password2)) {
            staffInfo.setPassword(password);
        }else {
            session.setAttribute("msg", "密码不一致！");
            return "staffReg";
        }

        int result = addStaff(staffInfo);
        if (result > 0) {
            session.setAttribute("msg", "注册成功请您登录！");
            return "staffReg";
        }
        if (result == -1) {
            session.setAttribute("msg", "手机号已被注册！");
            return "staffReg";
        }

        session.setAttribute("msg", "服务器繁忙！");
        return "staffReg";
    }

}
