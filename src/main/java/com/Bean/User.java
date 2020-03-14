package com.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户类
 */
public class User  implements Serializable {
    private int id;
    private String username;
    private String userpwd;
    private int solveNum;
    private String logintime;
    private int dayNum;
    private int ideaNum;


    public User(int id, String username, String userpwd, int solveNum, int dayNum, int ideaNum, String logintime) throws ParseException {
        this.id = id;
        this.username = username;
        this.userpwd = userpwd;
        this.solveNum = solveNum;
        this.logintime = logintime;
        this.dayNum = dayNum;
        this.ideaNum = ideaNum;


    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", solveNum=" + solveNum +
                ", logintime=" + logintime +
                ", dayNum=" + dayNum +
                ", ideaNum=" + ideaNum +
                '}';
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public User() {
    }

    public User(int id, String username, String userpwd, int solveNum, int dayNum, int ideaNum) {
        this.id = id;
        this.username = username;
        this.userpwd = userpwd;
        this.solveNum = solveNum;
        this.dayNum = dayNum;
        this.ideaNum = ideaNum;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public int getSolveNum() {
        return solveNum;
    }

    public void setSolveNum(int solveNum) {
        this.solveNum = solveNum;
    }

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public int getIdeaNum() {
        return ideaNum;
    }

    public void setIdeaNum(int ideaNum) {
        this.ideaNum = ideaNum;
    }
}
