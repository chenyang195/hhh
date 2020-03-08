package com.zhang.application.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 12:10 2020/3/5
 */
@Entity
@Table(name = "choice_question_info", schema = "zhang", catalog = "")
public class ChoiceQuestionInfo {
    private int id;
    private String problem;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private int relevanceJobId;

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
    @Column(name = "option_a")
    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    @Basic
    @Column(name = "option_b")
    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    @Basic
    @Column(name = "option_c")
    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    @Basic
    @Column(name = "option_d")
    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    @Basic
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
        ChoiceQuestionInfo that = (ChoiceQuestionInfo) o;
        return id == that.id &&
                relevanceJobId == that.relevanceJobId &&
                Objects.equals(problem, that.problem) &&
                Objects.equals(optionA, that.optionA) &&
                Objects.equals(optionB, that.optionB) &&
                Objects.equals(optionC, that.optionC) &&
                Objects.equals(optionD, that.optionD) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, problem, optionA, optionB, optionC, optionD, answer, relevanceJobId);
    }

    @Override
    public String toString() {
        return "ChoiceQuestionInfo{" +
                "id=" + id +
                ", problem='" + problem + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", answer='" + answer + '\'' +
                ", relevanceJobId=" + relevanceJobId +
                '}';
    }
}
