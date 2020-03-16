package com.zhang.application.Entity;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 18:37 2020/3/13
 */
public class UserRole  {
     Integer roleId;
     Integer userId;
     String roleName;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
