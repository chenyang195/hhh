package com.zhang.application.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 21:41 2020/3/15
 */
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
