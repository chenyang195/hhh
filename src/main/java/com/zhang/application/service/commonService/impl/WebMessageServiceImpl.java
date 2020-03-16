package com.zhang.application.service.commonService.impl;

import com.zhang.application.service.commonService.WebMessageService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 16:14 2020/3/14
 */
@Service
public class WebMessageServiceImpl implements WebMessageService {
    @Override
    public void setWebMessage(HttpSession session, String message) {
        session.setAttribute("msg",message);
    }

    @Override
    public String getWebMessage(HttpSession session) {
        String msg = (String) session.getAttribute("msg");
        if (msg==null){
            return "";
        }
        session.setAttribute("msg","");
        return msg;
    }
}
