package com.telia.uniservice.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.telia.uniservice.constants.ConstantErrorMessages;


@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {



  @ExceptionHandler(value = MyRestTemplateException.class)
  ResponseEntity<ErrorResponse> handleMyRestTemplateException(MyRestTemplateException ex, HttpServletRequest request) {
    return new ResponseEntity<>(new ErrorResponse(ex, request.getRequestURI()), ex.getStatusCode());
  }
  
  @ExceptionHandler(value =EmptyInputException.class)
  ResponseEntity<String> emptyInput(EmptyInputException empty) {
    return new ResponseEntity<String>(ConstantErrorMessages.IDENTITY_NUMBER_MANDATORY,HttpStatus.BAD_REQUEST);
  } 
  
  
}
