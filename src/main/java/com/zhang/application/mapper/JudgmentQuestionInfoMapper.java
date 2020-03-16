package com.zhang.application.mapper;


import com.zhang.application.Entity.JudgmentQuestionInfo;
import com.zhang.application.Entity.RoleAction;
import com.zhang.application.pojo.QuestionMapper;
import com.zhang.application.pojo.TkMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:26 2020/3/5
 */
@Mapper
@Component(value = "JudgmentQuestionInfoMapper")
public interface JudgmentQuestionInfoMapper extends QuestionMapper<JudgmentQuestionInfo> {


}
