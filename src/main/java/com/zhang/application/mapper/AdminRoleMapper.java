package com.zhang.application.mapper;


import com.zhang.application.Entity.ActionInfo;
import com.zhang.application.Entity.AdminRole;
import com.zhang.application.pojo.TkMapper;
import com.zhang.application.pojo.UserRoleMapper;
import org.apache.ibatis.annotations.Mapper;

;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 17:26 2020/3/5
 */
@Mapper
//@Component(value = "ActionInfoMapper")
public interface AdminRoleMapper extends UserRoleMapper<AdminRole> {


}
