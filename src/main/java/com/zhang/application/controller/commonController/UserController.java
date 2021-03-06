package com.zhang.application.controller.commonController;

import com.zhang.application.service.commonService.WebMessageService;
import com.zhang.application.utill.VerificationCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 21:18 2020/3/3
 */
@Controller
public class UserController {
    @Autowired
    WebMessageService webMessageService;
    @ResponseBody
    @RequestMapping("/getWebMsg")
    public String getWebMsg(HttpSession session){
        return webMessageService.getWebMessage(session);
    }
    //验证码
    @ResponseBody
    @RequestMapping("/getVerificationCode")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        BufferedOutputStream bos;


        try {
            bos = new BufferedOutputStream(response.getOutputStream());
            String value = VerificationCodeUtil.getVerificationCode(bos);
            bos.flush();
            bos.close();
            session.setAttribute("localCode", value);
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getMessage());

        }


    }

    //登出
    @RequestMapping("/logoutme")
    public void logout(HttpServletResponse response, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);

            }
        }
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error(e.getMessage());
        }

    }
}
/*
* public Map addUser(User user) {
        //设置默认头像
        String defaultImageURL =constant.getSource()+ "/default.jpeg";
        user.setImageURL(defaultImageURL);
        Map<String,String> map = new HashMap<>();
        //转换密码为加密后的
        String pass = MD5Encrypt.encrypt(user.getUsername(),user.getPassword()).toString();

        user.setPassword(pass);
        user.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
        if (userMapper.findByUsername(user.getUsername())!=null){
            map.put("msg","用户名已存在！");
            map.put("result","-1");
            return map;
        }
        Integer result =  userMapper.insertUser(user);
        user = userMapper.findByUsername(user.getUsername());
        roleService.setDefaultRole(user.getId());
        map.put("msg","注册成功请登录！");
        map.put("result",result.toString());
        return map;
    }*/