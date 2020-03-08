package com.zhang.application.mapper;

import com.zhang.application.pojo.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 22:24 2020/3/1
 */
@Mapper
public interface AnswerMapper {
    public Integer addAnswer(@Param("answer") Answer answer);
}
