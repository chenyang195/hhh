package com.zhang.application.Entity;

import javax.persistence.*;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 18:09 2020/3/13
 */
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String phoneNum;
    @Basic
    @Column(name = "phone_num")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
