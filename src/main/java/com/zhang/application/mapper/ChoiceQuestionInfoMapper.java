package com.zhang.application.mapper;

import com.zhang.application.Entity.ChoiceQuestionInfo;
import com.zhang.application.pojo.QuestionMapper;
import com.zhang.application.pojo.TkMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 16:41 2020/3/5
 */
@Mapper
@Component(value = "ChoiceQuestionInfoMapper")
public interface ChoiceQuestionInfoMapper extends QuestionMapper<ChoiceQuestionInfo> {
}
