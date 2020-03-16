package com.zhang.application.utill;





import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 21:35 2020/3/3
 */
public class MSMUtill {
    public static boolean sendMSM(String phoneNum,String content) {
        String host = "https://dxyzm.market.alicloudapi.com";
        String path = "/chuangxin/dxjk";
        String method = "POST";
        String appcode = "97ed093b5de74c56bf41e2449dd06481";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        //测试可用默认短信模板,测试模板为专用模板不可修改,如需自定义短信内容或改动任意字符,请联系旺旺或QQ726980650进行申请
        querys.put("content", "【创信】你的验证码是：5873，3分钟内有效！");
        querys.put("mobile", phoneNum);
        Map<String, String> bodys = new HashMap<String, String>();

        try {

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

        /* "ReturnStatus": "Success",
        "Message": "ok",
        "RemainPoint": 420842,
        "TaskID": 18424321,
        "SuccessCounts": 1*/
           /* HttpParams params = response.getParams();

            String returnStatus = (String) params.getParameter("ReturnStatus");
            if (returnStatus.equals("Success")){
                return true;
            }
            System.out.println(params.getParameter("Message"));*/
            System.out.println(EntityUtils.toString(response.getEntity()));

            return true;
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
