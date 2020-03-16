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
@Table(name = "judgment_question_info", schema = "zhang", catalog = "")
public class JudgmentQuestionInfo extends Question {
    @Override
    public String toString() {
        return "JudgmentQuestionInfo{" +
                "id=" + id +
                ", problem='" + problem + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }


    private String problem;
    private Integer answer;

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
    @Column(name = "answer")
    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JudgmentQuestionInfo that = (JudgmentQuestionInfo) o;
        return id == that.id &&
                Objects.equals(problem, that.problem) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, problem, answer);
    }
}
