package com.zhang.application.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
@Table(name = "applicant_role", schema = "zhang", catalog = "")
public class ApplicantRole extends UserRole{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public String toString() {
        return "ApplicantRole{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", userId=" + userId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @Basic
    @Column(name = "role_id")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicantRole that = (ApplicantRole) o;
        return id == that.id &&
                userId == that.userId &&
                roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roleId);
    }
}
