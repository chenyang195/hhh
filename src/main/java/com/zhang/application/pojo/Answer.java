package com.zhang.application.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
public class Answer {
    private int q1;
    private int q2;
    private String w1;
    private int id;
    private int applicantId;

    @Basic
    @Column(name = "q1")
    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    @Basic
    @Column(name = "q2")
    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    @Basic
    @Column(name = "w1")
    public String getW1() {
        return w1;
    }

    public void setW1(String w1) {
        this.w1 = w1;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "applicant_id")
    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return q1 == answer.q1 &&
                q2 == answer.q2 &&
                id == answer.id &&
                applicantId == answer.applicantId &&
                Objects.equals(w1, answer.w1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(q1, q2, w1, id, applicantId);
    }
}
