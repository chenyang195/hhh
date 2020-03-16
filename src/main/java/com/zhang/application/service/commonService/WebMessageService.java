package com.zhang.application.service.commonService;

import javax.servlet.http.HttpSession;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 16:03 2020/3/14
 */
public interface WebMessageService {
    public void setWebMessage(HttpSession session,String message);
    public String getWebMessage(HttpSession session);

}
