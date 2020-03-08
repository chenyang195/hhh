package com.zhang.application.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
@Table(name = "admin_role", schema = "zhang", catalog = "")
public class AdminRole {
    private int id;
    private int adminId;
    private int roleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "admin_id")
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminRole adminRole = (AdminRole) o;
        return id == adminRole.id &&
                adminId == adminRole.adminId &&
                roleId == adminRole.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adminId, roleId);
    }
}
