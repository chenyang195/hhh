package com.zhang.application.controller;

import com.alibaba.fastjson.JSON;
import com.zhang.application.Entity.ChoiceQuestionInfo;
import com.zhang.application.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 16:53 2020/3/5
 */
@Controller
public class QuestionController {
    @Resource
    QuestionService questionService;
    @ResponseBody
    @RequestMapping("/getAllChoiceQuestion")
    public String getAllChoiceQuestion(){
        List<ChoiceQuestionInfo> allChoiceQuestion = questionService.getAllChoiceQuestion();

        return  JSON.toJSONString(allChoiceQuestion);
    }
}
