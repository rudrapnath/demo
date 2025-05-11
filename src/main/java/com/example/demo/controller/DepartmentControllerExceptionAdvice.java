package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class DepartmentControllerExceptionAdvice {
    @ExceptionHandler(value = DepartmentNotExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Hidden
    @ResponseBody
    public ResponseEntity<ErrorResponseDtl> handleServerException(DepartmentNotExistException ex) {
        ErrorResponseDtl error= new ErrorResponseDtl();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponseDtl>(error, HttpStatus.BAD_REQUEST);
    }
  /*  @ExceptionHandler(value = DepartmentNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotFOundException(DepartmentNotExistException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
*/
}
