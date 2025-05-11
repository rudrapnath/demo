package com.example.demo.controller;

public class DepartmentNotExistException extends RuntimeException {

    private String message;

    public DepartmentNotExistException() {}

    public DepartmentNotExistException(String msg) {
        super(msg);
        this.message = msg;
    }
}
