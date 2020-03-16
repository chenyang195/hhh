package com.zhang.application.mapper;

import com.zhang.application.Entity.AdminRole;
import com.zhang.application.Entity.StaffRolesInfo;
import com.zhang.application.pojo.TkMapper;
import com.zhang.application.pojo.UserRoleMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 20:57 2020/3/10
 */
@Mapper
public interface StaffRolesInfoMapper extends UserRoleMapper<StaffRolesInfo> {
     /*List<StaffRole> getRolesByStaffId(@Param("staffId")int staffId);
     Integer addRolesById(@Param("id")int id);*/

}
