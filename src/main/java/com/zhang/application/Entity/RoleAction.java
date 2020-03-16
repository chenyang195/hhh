package com.zhang.application.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
@Table(name = "role_action", schema = "zhang", catalog = "")
public class RoleAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer roleId;
    private Integer actionId;
    private String actionName;

    @Override
    public String toString() {
        return "RoleAction{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", actionId=" + actionId +
                ", actionName='" + actionName + '\'' +
                '}';
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
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

    @Basic
    @Column(name = "action_id")
    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleAction that = (RoleAction) o;
        return id == that.id &&
                roleId == that.roleId &&
                actionId == that.actionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, actionId);
    }
}
