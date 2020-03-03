package com.zhang.application.controller;

import com.zhang.application.mapper.AnswerMapper;
import com.zhang.application.pojo.Answer;
import com.zhang.application.utill.MSMUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @Author : zhang
 * @Description :
 * @Date: Created in 22:03 2020/3/1
 */

@Controller
public class ApplicantController {
    @Resource
    AnswerMapper answerMapper;



    @RequestMapping("/subAns")
    public String subAns(@RequestParam("q1")String q1,@RequestParam("q2")String q2,@RequestParam("w1")String w1){
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

    @RequestMapping("/question")
    public String question(){
        return "question";
    }


}
