package com.utils;

import org.springframework.stereotype.Component;

public class Message {
    private int code;
    private String Mes;
    private Object data;


    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", Mes='" + Mes + '\'' +
                ", data=" + data +
                '}';
    }

    public Message(int code, String mes, Object data) {
        this.code = code;
        Mes = mes;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String mes) {
        Mes = mes;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
