package com.zhang.application.mapper;


import com.zhang.application.Entity.ApplicantInfo;
import com.zhang.application.Entity.JobInfo;
import com.zhang.application.pojo.TkMapper;
import com.zhang.application.pojo.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:26 2020/3/5
 */
@Mapper
@Component(value = "ApplicantInfoMapper")
public interface ApplicantInfoMapper extends UserMapper<ApplicantInfo> {


}
