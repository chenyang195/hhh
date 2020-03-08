package com.zhang.application.mapper;


import com.zhang.application.Entity.JobInfo;
import com.zhang.application.Entity.RoleAction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:26 2020/3/5
 */
@Mapper
@Component(value = "JobInfoMapper")
public interface JobInfoMapper extends TkMapper<JobInfo> {


}
