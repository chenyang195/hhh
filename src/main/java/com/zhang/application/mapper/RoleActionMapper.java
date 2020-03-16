package com.zhang.application.mapper;


import com.zhang.application.Entity.ApplicantRole;
import com.zhang.application.Entity.RoleAction;
import com.zhang.application.pojo.TkMapper;
import org.apache.ibatis.annotations.Mapper;

;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:26 2020/3/5
 */
@Mapper
//@Component(value = "ActionInfoMapper")
public interface RoleActionMapper extends TkMapper<RoleAction> {


}
