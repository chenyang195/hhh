package com.zhang.application.service.questionService.impl;

import com.zhang.application.Entity.ChoiceQuestionInfo;
import com.zhang.application.mapper.ChoiceQuestionInfoMapper;
import com.zhang.application.mapper.EssayQuestionInfoMapper;
import com.zhang.application.mapper.JudgmentQuestionInfoMapper;
import com.zhang.application.pojo.Question;
import com.zhang.application.pojo.QuestionMapper;
import com.zhang.application.pojo.Questions;
import com.zhang.application.service.questionService.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 16:49 2020/3/5
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    ChoiceQuestionInfoMapper choiceQuestionInfoMapper;
    @Resource
    EssayQuestionInfoMapper essayQuestionInfoMapper;
    @Resource
    JudgmentQuestionInfoMapper judgmentQuestionInfoMapper;
    @Override
    public List<ChoiceQuestionInfo> getAllChoiceQuestion() {
        List<ChoiceQuestionInfo> list = choiceQuestionInfoMapper.selectAll();
        return list;
    }

    @Override
    public Questions getQuestions(ServletContext servletContext) {


        Questions questions = new Questions();
        questions.clean();
        addQuestion(servletContext,questions,"CQId",choiceQuestionInfoMapper,4);
        addQuestion(servletContext,questions,"JQId",judgmentQuestionInfoMapper,3);
        addQuestion(servletContext,questions,"EQId",essayQuestionInfoMapper,2);
        return questions;
    }

    void addQuestion(ServletContext servletContext,Questions questions,String listName, QuestionMapper questionMapper,int qNum){
        int num = qNum;
        List<Integer> questionIdList = (ArrayList<Integer>) servletContext.getAttribute(listName);
        if (questionIdList==null){
            questionIdList = new  ArrayList<>();
            List<Question> questionInfoList = questionMapper.selectAll();

            if (questionInfoList!=null){
                for (Question q: questionInfoList) {

                    questionIdList.add(q.getId());
                }
                List<Integer> list = new ArrayList<>(questionIdList);

                servletContext.setAttribute(listName,list);
            }
            if (questionIdList.size()<qNum){
                questions.setChoiceQuestionInfos(null);
            }else {
                addOneList(num,questionIdList,questionMapper,questions);

            }
        }else {
            addOneList(num,questionIdList,questionMapper,questions);
        }
    }
    void addOneList(int num,List<Integer> idList, QuestionMapper questionMapper,Questions questions){
        List<Integer> questionIdList = new ArrayList<>(idList);
        Random rand = new Random(System.currentTimeMillis());
        int index;
        for (int i= 0;i<num;i++){

            index = rand.nextInt(questionIdList.size() - 1);
            Integer integer = questionIdList.get(index);
            Question question= (Question)questionMapper.selectByPrimaryKey(integer);
            questions.addQuestion(question);
            questionIdList.remove(index);
        }
    }

}
