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
public class AdminRole extends UserRole {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roleName;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminRole adminRole = (AdminRole) o;
        return id == adminRole.id &&
                userId == adminRole.userId &&
                roleId == adminRole.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roleId);
    }
}
