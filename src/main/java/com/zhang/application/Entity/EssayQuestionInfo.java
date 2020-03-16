package com.zhang.application.Entity;

import com.zhang.application.pojo.Question;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
@Table(name = "essay_question_info", schema = "zhang", catalog = "")
public class EssayQuestionInfo extends Question {
    @Override
    public String toString() {
        return "EssayQuestionInfo{" +
                "id=" + id +
                ", problem='" + problem + '\'' +
                ", keys='" + kkeys + '\'' +
                ", relevanceJobId=" + relevanceJobId +
                ", fullMarksKeysNum=" + fullMarksKeysNum +
                '}';
    }


    private String problem;
    private String kkeys;
    private Integer relevanceJobId;
    private Integer fullMarksKeysNum;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Basic
    @Column(name = "problem")
    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Basic
    @Column(name = "keys")
    public String getKeys() {
        return kkeys;
    }

    public void setKeys(String keys) {
        this.kkeys = keys;
    }

    @Basic
    @Column(name = "relevance_job_id")
    public Integer getRelevanceJobId() {
        return relevanceJobId;
    }

    public void setRelevanceJobId(Integer relevanceJobId) {
        this.relevanceJobId = relevanceJobId;
    }

    @Basic
    @Column(name = "full_marks_keys_num")
    public Integer getFullMarksKeysNum() {
        return fullMarksKeysNum;
    }

    public void setFullMarksKeysNum(Integer fullMarksKeysNum) {
        this.fullMarksKeysNum = fullMarksKeysNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EssayQuestionInfo that = (EssayQuestionInfo) o;
        return id == that.id &&
                relevanceJobId == that.relevanceJobId &&
                fullMarksKeysNum == that.fullMarksKeysNum &&
                Objects.equals(problem, that.problem) &&
                Objects.equals(kkeys, that.kkeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, problem, kkeys, relevanceJobId, fullMarksKeysNum);
    }



}
