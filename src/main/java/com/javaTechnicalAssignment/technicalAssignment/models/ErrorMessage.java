package com.javaTechnicalAssignment.technicalAssignment.models;

public class ErrorMessage {

    //defining fields
    private String msg;

    //constructor

    public ErrorMessage() {
    }

    public ErrorMessage(String msg) {
        this.msg = msg;
    }

    //getter and setter

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
