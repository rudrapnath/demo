package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response  {

    String responseMsg;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
    public Response() {}
    public Response(String response) {
        this.responseMsg = response;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }



    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public void setResponseMsg(String responseMsg) {}
}
