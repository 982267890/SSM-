package com.Bean;

/**
 * 题目答案类
 */
public class QuestionContent {
    private int questionId;
    private String questionCont;
    private String quesetionAnser;
    private String abcd;
    private String code;

    @Override
    public String toString() {
        return "QuestionContent{" +
                "questionId=" + questionId +
                ", questionCont='" + questionCont + '\'' +
                ", quesetionAnser='" + quesetionAnser + '\'' +
                ", abcd='" + abcd + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionCont() {
        return questionCont;
    }

    public void setQuestionCont(String questionCont) {
        this.questionCont = questionCont;
    }

    public String getQuesetionAnser() {
        return quesetionAnser;
    }

    public void setQuesetionAnser(String quesetionAnser) {
        this.quesetionAnser = quesetionAnser;
    }

    public String getAbcd() {
        return abcd;
    }

    public void setAbcd(String abcd) {
        this.abcd = abcd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
