package com.zhang.application.service.impl;

import com.zhang.application.Entity.ChoiceQuestionInfo;
import com.zhang.application.mapper.ChoiceQuestionInfoMapper;
import com.zhang.application.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 16:49 2020/3/5
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    ChoiceQuestionInfoMapper choiceQuestionInfoMapper;
    @Override
    public List<ChoiceQuestionInfo> getAllChoiceQuestion() {
        List<ChoiceQuestionInfo> list = choiceQuestionInfoMapper.selectAll();
        return list;
    }
}
