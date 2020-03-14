package com.Bean;

import java.io.Serializable;

/**
 * 回答类
 */
public class Contnet  implements Serializable {
    private int questionId;
    private String anwers;
    private String username;

    @Override
    public String toString() {
        return "Contnet{" +
                "questionId=" + questionId +
                ", anwers='" + anwers + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnwers() {
        return anwers;
    }

    public void setAnwers(String anwers) {
        this.anwers = anwers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
