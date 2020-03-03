package com.zhang.application.pojo;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 22:26 2020/3/1
 */
public class Answer {
    Integer q1;
    Integer q2;
    String w1;
    Integer id;
    Integer applicantId;

    @Override
    public String toString() {
        return "Answer{" +
                "q1=" + q1 +
                ", q2=" + q2 +
                ", w1='" + w1 + '\'' +
                ", id=" + id +
                ", applicantId=" + applicantId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getQ1() {
        return q1;
    }

    public void setQ1(Integer q1) {
        this.q1 = q1;
    }

    public Integer getQ2() {
        return q2;
    }

    public void setQ2(Integer q2) {
        this.q2 = q2;
    }

    public String getW1() {
        return w1;
    }

    public void setW1(String w1) {
        this.w1 = w1;
    }

    public Answer() {
    }

    public Answer(Integer q1, Integer q2, String w1) {
        this.q1 = q1;
        this.q2 = q2;
        this.w1 = w1;
    }
}
