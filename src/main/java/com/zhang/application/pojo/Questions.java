package com.zhang.application.pojo;

import com.zhang.application.Entity.ChoiceQuestionInfo;
import com.zhang.application.Entity.EssayQuestionInfo;
import com.zhang.application.Entity.JudgmentQuestionInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : YangChen
 * @Description :
 * @Date: Created in 20:51 2020/3/15
 */
public class Questions implements Serializable {

    static List<ChoiceQuestionInfo> choiceQuestionInfos = new ArrayList<>();
    static List<JudgmentQuestionInfo> judgmentQuestionInfos = new ArrayList<>();
    static List<EssayQuestionInfo> essayQuestionInfos = new ArrayList<>();

    public void clean(){
        choiceQuestionInfos.clear();
        judgmentQuestionInfos.clear();
        essayQuestionInfos.clear();
    }
    public void addQuestion(Question question){
        if (question.getClass().equals(ChoiceQuestionInfo.class)){
            addChoiceQuestionInfo((ChoiceQuestionInfo) question);
            return;
        }
        if (question.getClass().equals(JudgmentQuestionInfo.class)){
            addJudgmentQuestionInfo((JudgmentQuestionInfo) question);
            return;
        }
        if (question.getClass().equals(EssayQuestionInfo.class)){
            addEssayQuestionInfo((EssayQuestionInfo) question);
            return;
        }
    }
    public void addChoiceQuestionInfo(ChoiceQuestionInfo choiceQuestionInfo){
        choiceQuestionInfos.add(choiceQuestionInfo);
    }
    public void addJudgmentQuestionInfo(JudgmentQuestionInfo judgmentQuestionInfo){
        judgmentQuestionInfos.add(judgmentQuestionInfo);
    }
    public void addEssayQuestionInfo(EssayQuestionInfo essayQuestionInfo){
        essayQuestionInfos.add(essayQuestionInfo);
    }
    public List<ChoiceQuestionInfo> getChoiceQuestionInfos() {
        return choiceQuestionInfos;
    }

    public void setChoiceQuestionInfos(List<ChoiceQuestionInfo> choiceQuestionInfos) {
        this.choiceQuestionInfos = choiceQuestionInfos;
    }

    public List<JudgmentQuestionInfo> getJudgmentQuestionInfos() {
        return judgmentQuestionInfos;
    }

    public void setJudgmentQuestionInfos(List<JudgmentQuestionInfo> judgmentQuestionInfos) {
        this.judgmentQuestionInfos = judgmentQuestionInfos;
    }

    public List<EssayQuestionInfo> getEssayQuestionInfos() {
        return essayQuestionInfos;
    }

    public void setEssayQuestionInfos(List<EssayQuestionInfo> essayQuestionInfos) {
        this.essayQuestionInfos = essayQuestionInfos;
    }
}
