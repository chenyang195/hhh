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
@Table(name = "applicant_info", schema = "zhang", catalog = "")
public class ApplicantInfo extends User {


    private String name;

    private String password;
    private String imageUrl;
    private Timestamp createTime;
    private Date birthday;
    private String idCardNum;
    private int relevanceJobId;
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

    @Override
    public String toString() {
        return "ApplicantInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createTime=" + createTime +
                ", birthday=" + birthday +
                ", idCardNum='" + idCardNum + '\'' +
                ", relevanceJobId=" + relevanceJobId +
                ", id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
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

    @Basic
    @Column(name = "relevance_job_id")
    public int getRelevanceJobId() {
        return relevanceJobId;
    }

    public void setRelevanceJobId(int relevanceJobId) {
        this.relevanceJobId = relevanceJobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicantInfo that = (ApplicantInfo) o;
        return id == that.id &&
                relevanceJobId == that.relevanceJobId &&
                Objects.equals(name, that.name) &&
                Objects.equals(phoneNum, that.phoneNum) &&
                Objects.equals(password, that.password) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(idCardNum, that.idCardNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNum, password, imageUrl, createTime, birthday, idCardNum, relevanceJobId);
    }




}
