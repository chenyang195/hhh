package com.zhang.application.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
@Table(name = "essay_question_info", schema = "zhang", catalog = "")
public class EssayQuestionInfo {
    private int id;
    private String problem;
    private String keys;
    private int relevanceJobId;
    private int fullMarksKeysNum;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    @Basic
    @Column(name = "relevance_job_id")
    public int getRelevanceJobId() {
        return relevanceJobId;
    }

    public void setRelevanceJobId(int relevanceJobId) {
        this.relevanceJobId = relevanceJobId;
    }

    @Basic
    @Column(name = "full_marks_keys_num")
    public int getFullMarksKeysNum() {
        return fullMarksKeysNum;
    }

    public void setFullMarksKeysNum(int fullMarksKeysNum) {
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
                Objects.equals(keys, that.keys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, problem, keys, relevanceJobId, fullMarksKeysNum);
    }
}
