package com.zhang.application.mapper;


import com.zhang.application.Entity.ActionInfo;
import com.zhang.application.Entity.AdminInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:26 2020/3/5
 */
@Mapper
@Component(value = "ActionInfoMapper")
public interface ActionInfoMapper extends TkMapper<ActionInfo> {


}
