package com.zhang.application.controller.questionController;

import com.alibaba.fastjson.JSON;
import com.zhang.application.Entity.ChoiceQuestionInfo;
import com.zhang.application.mapper.AnswerMapper;
import com.zhang.application.mapper.ChoiceQuestionInfoMapper;
import com.zhang.application.mapper.EssayQuestionInfoMapper;
import com.zhang.application.mapper.JudgmentQuestionInfoMapper;
import com.zhang.application.pojo.Answer;
import com.zhang.application.pojo.Questions;
import com.zhang.application.service.questionService.QuestionService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 16:53 2020/3/5
 */
@Controller
public class QuestionController {
    @Resource
    AnswerMapper answerMapper;
    @Resource
    QuestionService questionService;

    @ResponseBody
    @RequestMapping("/getAllChoiceQuestion")
    public String getAllChoiceQuestion(){
        List<ChoiceQuestionInfo> allChoiceQuestion = questionService.getAllChoiceQuestion();

        return  JSON.toJSONString(allChoiceQuestion);
    }

    @RequestMapping("/subAns")
    public String subAns(@RequestParam("q1")String q1, @RequestParam("q2")String q2, @RequestParam("w1")String w1){
        System.out.println("q1:"+q1+"  q2:"+q2+"  w1:"+w1);
        Answer answer = new Answer();

        if (q1.equals("a")){
            answer.setQ1(1);
        }else {
            answer.setQ1(0);
        }
        if (q2.equals("true")){
            answer.setQ2(1);
        }else {
            answer.setQ2(0);
        }
        answer.setW1(w1);
        answer.setApplicantId(112233);

        answerMapper.addAnswer(answer);
        System.out.println(answer.getId());

        return "question";
    }
    @ResponseBody
    @GetMapping("/getQuestions")
    public String getQuestions(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        Questions questions = questionService.getQuestions(servletContext);
        if (questions==null){
            return "";
        }
        return JSON.toJSONString(questions);
    }

}
