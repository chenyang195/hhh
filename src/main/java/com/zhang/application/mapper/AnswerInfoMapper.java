package com.zhang.application.mapper;


import com.zhang.application.Entity.AnswerInfo;
import com.zhang.application.Entity.JobInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:26 2020/3/5
 */
@Mapper
@Component(value = "AnswerInfoMapper")
public interface AnswerInfoMapper extends TkMapper<AnswerInfo> {


}
