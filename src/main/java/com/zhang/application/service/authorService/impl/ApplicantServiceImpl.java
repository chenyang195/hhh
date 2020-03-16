package com.zhang.application.service.authorService.impl;

import com.zhang.application.Entity.ApplicantInfo;
import com.zhang.application.Entity.ApplicantRole;
import com.zhang.application.Entity.Referees;
import com.zhang.application.mapper.ApplicantInfoMapper;
import com.zhang.application.mapper.ApplicantRoleMapper;
import com.zhang.application.mapper.RefereesMapper;
import com.zhang.application.service.authorService.ApplicantService;
import com.zhang.application.service.commonService.WebMessageService;
import com.zhang.application.utill.MD5Encrypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 14:44 2020/3/8
 */
@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Resource
    ApplicantInfoMapper applicantInfoMapper;
    @Resource
    ApplicantRoleMapper applicantRoleMapper;
    @Resource
    RefereesMapper refereesMapper;
    @Autowired
    WebMessageService webMessageService;


    //注册用户
    @Override
    public Integer addApplicant(ApplicantInfo applicantInfo) {
        String enPassword = MD5Encrypt.encrypt(applicantInfo.getPhoneNum(),applicantInfo.getPassword()).toString();
        applicantInfo.setPassword(enPassword);
        ApplicantInfo applicantInfoCkeck = applicantInfoMapper.selectOne(applicantInfo);
        if (applicantInfoCkeck!=null){
            return -1;
        }
        String idCardNum = applicantInfo.getIdCardNum();
        applicantInfoMapper.insert(applicantInfo);
        Integer id = applicantInfo.getId();
        //添加推荐条目
        if(idCardNum!=null){
            Referees referees = new Referees();
            referees.setApplicantId(id);
            referees.setStaffIdCadId(Integer.parseInt(idCardNum));
            referees.setStatus(1);
            Referees referees1 = refereesMapper.selectOne(referees);
            if (referees1==null){
                refereesMapper.insert(referees);
            }
        }

        //设置默认权限
        if(id>0){
            ApplicantRole applicantRole = new ApplicantRole();

            int[] roleIds = {2,5};
            for (int roleId: roleIds) {
                applicantRole.setId(null);
                applicantRole.setUserId(id);
                applicantRole.setRoleId(roleId);
                applicantRoleMapper.insert(applicantRole);
            }
        }



        return id;
    }
    //登录校验
    @Override
    public String applicantLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (request.getParameter("code")==null){

            return "/applicantLog";
        }
        Object localCode1 = session.getAttribute("localCode");
        if (localCode1==null){
            return "/applicantLog";
        }
        String localCode = localCode1.toString();



        if(!(request.getParameter("code").equalsIgnoreCase(localCode))){

            session.setAttribute("msg","验证码错误");
            return "/applicantLog";
        }
        String phoneNum = request.getParameter("phoneNum");
        if (phoneNum==null){
            session.setAttribute("msg","请输入手机号！");
            return "/applicantLog";
        }else {
            ApplicantInfo applicantInfo = new ApplicantInfo();
            applicantInfo.setPhoneNum(phoneNum);
            applicantInfo = applicantInfoMapper.selectOne(applicantInfo);
            if (applicantInfo==null){
                session.setAttribute("msg","手机号"+phoneNum+"未注册！");
                return "/applicantLog";
            }
        }
        String password = request.getParameter("password");
        if (password==null){
            session.setAttribute("msg","请输密码！");
            return "/applicantLog";
        }
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("phoneNum"),request.getParameter("password"));
        token.setRememberMe(true);
        /* String remeberme = request.getParameter("remeberme");
        if(remeberme==null){
            if (remeberme.equals("on")){
                token.setRememberMe(true);
            }

        }*/
        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        //3.执行登录方法
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //System.out.println("无用户");
            session.setAttribute("msg","用户名不存在");
            return "/applicantLog";
        }catch (IncorrectCredentialsException e){
            //System.out.println("密码错");
            session.setAttribute("msg","密码错误");
            return "/applicantLog";
        }catch (AuthenticationException e){
            session.setAttribute("msg","登录错误");
            return "/applicantLog";
        }
        if (savedRequest == null || savedRequest.getRequestUrl() == null) {

            session.setAttribute("msg","登录成功");
            return "index";


        }
        session.setAttribute("msg","登录成功");
        return "index"; /*savedRequest.getRequestUrl();*/

    }

    @Override
    public String applicantRegin(HttpServletRequest request) {
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
        ApplicantInfo applicantInfo = new ApplicantInfo();
        String phoneNum = request.getParameter("phoneNum");
        if (phoneNum == null) {
            session.setAttribute("msg", "未填写电话号码！");
            return "applicantReg";
        }
        applicantInfo.setPhoneNum(phoneNum);
        //存密码
        String password = request.getParameter("password");
        if (password == null) {
            session.setAttribute("msg", "未填写密码！");
            return "applicantReg";
        }
        String password2 = request.getParameter("password2");
        if (password2 == null) {
            session.setAttribute("msg", "未再次填写密码！");
            return "applicantReg";
        }
        if (password.equals(password2)) {
            applicantInfo.setPassword(password);
        }else {
            session.setAttribute("msg", "密码不一致！");
            return "applicantReg";
        }
        //存推荐者工号
        String staffNum = request.getParameter("staffNum");
        applicantInfo.setIdCardNum(staffNum);
        int result = addApplicant(applicantInfo);
        if (result > 0) {
            session.setAttribute("msg", "注册成功请您登录！");
            return "applicantLog";
        }
        if (result == -1) {
            session.setAttribute("msg", "手机号已被注册！");
            return "applicantReg";
        }

        session.setAttribute("msg", "服务器繁忙！");
        return "applicantReg";
    }
    //设置默认角色

}
