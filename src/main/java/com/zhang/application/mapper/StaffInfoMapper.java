package com.zhang.application.mapper;


import com.zhang.application.Entity.StaffInfo;
;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:26 2020/3/5
 */
@Mapper
@Component(value = "staffInfoMapper")
public interface StaffInfoMapper extends TkMapper<StaffInfo> {


}
