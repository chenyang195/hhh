package com.zhang.application.service.questionService;

import com.zhang.application.Entity.ChoiceQuestionInfo;
import com.zhang.application.pojo.Questions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.util.List;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 16:47 2020/3/5
 */
public interface QuestionService {
    public List<ChoiceQuestionInfo> getAllChoiceQuestion();
    public Questions getQuestions(ServletContext servletContext);
}
