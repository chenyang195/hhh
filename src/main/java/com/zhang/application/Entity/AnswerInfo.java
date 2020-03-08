package com.zhang.application.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
@Table(name = "answer_info", schema = "zhang", catalog = "")
public class AnswerInfo {
    private String id;
    private String answers;
    private double score;
    private int applicantId;
    private int relevanceJobId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "answers")
    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Basic
    @Column(name = "score")
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "applicant_id")
    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
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
        AnswerInfo that = (AnswerInfo) o;
        return Double.compare(that.score, score) == 0 &&
                applicantId == that.applicantId &&
                relevanceJobId == that.relevanceJobId &&
                Objects.equals(id, that.id) &&
                Objects.equals(answers, that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answers, score, applicantId, relevanceJobId);
    }
}
