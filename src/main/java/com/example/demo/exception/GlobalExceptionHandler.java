package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(StudentNotFoundException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiException handleNotFoundException(StudentNotFoundException exception) {
    return new ApiException(HttpStatus.BAD_REQUEST, exception.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ApiException handleException(Exception exception, HttpServletRequest request) {
    return new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!", request.getServletPath());
  }


}
