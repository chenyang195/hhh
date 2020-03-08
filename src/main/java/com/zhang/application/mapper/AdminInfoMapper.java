package com.zhang.application.mapper;


import com.zhang.application.Entity.AdminInfo;
import com.zhang.application.Entity.AdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:26 2020/3/5
 */
@Mapper
@Component(value = "AdminInfoMapper")
public interface AdminInfoMapper extends TkMapper<AdminInfo> {


}
