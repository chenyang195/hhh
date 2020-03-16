package com.zhang.application.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
@Table(name = "job_info", schema = "zhang", catalog = "")
public class JobInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String describe;
    private Date startTime;
    private Date endTime;
    private Integer jobNum;
    private String title;
    private Integer deliverNum;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Basic
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "job_num")
    public Integer getJobNum() {
        return jobNum;
    }

    public void setJobNum(Integer jobNum) {
        this.jobNum = jobNum;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "deliver_num")
    public Integer getDeliverNum() {
        return deliverNum;
    }

    public void setDeliverNum(Integer deliverNum) {
        this.deliverNum = deliverNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobInfo jobInfo = (JobInfo) o;
        return id == jobInfo.id &&
                Objects.equals(describe, jobInfo.describe) &&
                Objects.equals(startTime, jobInfo.startTime) &&
                Objects.equals(endTime, jobInfo.endTime) &&
                Objects.equals(jobNum, jobInfo.jobNum) &&
                Objects.equals(title, jobInfo.title) &&
                Objects.equals(deliverNum, jobInfo.deliverNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, describe, startTime, endTime, jobNum, title, deliverNum);
    }
}
