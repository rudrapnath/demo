package com.example.demo.controller;
// Custom Error Response Class

public class ErrorResponseDtl {

    private int statusCode;
    private String message;

    public ErrorResponseDtl() {}
    public ErrorResponseDtl(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;

    }
    public ErrorResponseDtl(String message)
    {
        super();
        this.message = message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}