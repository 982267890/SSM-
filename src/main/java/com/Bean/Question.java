package com.Bean;

import org.springframework.context.annotation.Bean;

public class Question {
    private int questionId;
    private int questionNum;
    private String questionName;
    private int zanNum;
    private int watchNum;
    private int commentsNum;

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionNum=" + questionNum +
                ", questionName='" + questionName + '\'' +
                ", zanNum=" + zanNum +
                ", watchNum=" + watchNum +
                ", commentsNum=" + commentsNum +
                '}';
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public int getZanNum() {
        return zanNum;
    }

    public void setZanNum(int zanNum) {
        this.zanNum = zanNum;
    }

    public int getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(int watchNum) {
        this.watchNum = watchNum;
    }

    public int getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(int commentsNum) {
        this.commentsNum = commentsNum;
    }
}
