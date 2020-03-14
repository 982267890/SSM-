package com.Bean;

import java.io.Serializable;

public class Solvenum implements Serializable {
    private int id;
    private int solveNum;

    public Solvenum(int id, int solveNum) {
        this.id = id;
        this.solveNum = solveNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSolveNum() {
        return solveNum;
    }

    public void setSolveNum(int solveNum) {
        this.solveNum = solveNum;
    }
}
