package com.zhang.application.service;

import com.zhang.application.Entity.ChoiceQuestionInfo;

import java.util.List;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 16:47 2020/3/5
 */
public interface QuestionService {
    public List<ChoiceQuestionInfo> getAllChoiceQuestion();
}
