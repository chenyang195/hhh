package com.zhang.application.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
@Table(name = "staff_info", schema = "zhang", catalog = "")
@SuppressWarnings("ALL")
public class StaffInfo extends User {

    private String name;
    private String phoneNum;
    private String password;
    private String imageUrl;
    private Timestamp createTime;
    private Date birthday;
    private String idCardNum;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone_num")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "id_card_num")
    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffInfo staffInfo = (StaffInfo) o;
        return id == staffInfo.id &&
                Objects.equals(name, staffInfo.name) &&
                Objects.equals(phoneNum, staffInfo.phoneNum) &&
                Objects.equals(password, staffInfo.password) &&
                Objects.equals(imageUrl, staffInfo.imageUrl) &&
                Objects.equals(createTime, staffInfo.createTime) &&
                Objects.equals(birthday, staffInfo.birthday) &&
                Objects.equals(idCardNum, staffInfo.idCardNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNum, password, imageUrl, createTime, birthday, idCardNum);
    }
}
