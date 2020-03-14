package com.Bean;

import java.io.Serializable;

public class Ideanum implements Serializable {
    private int id;
    private int ideaNum;

    public Ideanum(int id, int ideaNum) {
        this.id = id;
        this.ideaNum = ideaNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdeaNum() {
        return ideaNum;
    }

    public void setIdeaNum(int ideaNum) {
        this.ideaNum = ideaNum;
    }
}
