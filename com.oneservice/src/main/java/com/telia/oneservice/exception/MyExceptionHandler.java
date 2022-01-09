package com.telia.oneservice.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);


  @ExceptionHandler(value = MyRestTemplateException.class)
  ResponseEntity<ErrorResponse> handleMyRestTemplateException(MyRestTemplateException ex, HttpServletRequest request) {
  logger.error("An error happened while calling {} Downstream API: {}", ex.getApi(), ex.toString());
    return new ResponseEntity<>(new ErrorResponse(ex, request.getRequestURI()), ex.getStatusCode());
  }
  
  @ExceptionHandler(value =EmptyInputException.class)
  ResponseEntity<String> emptyInput(EmptyInputException empty) {
    return new ResponseEntity<String>("Identity Number is Mandatory",HttpStatus.BAD_REQUEST);
  } 
  
  
}
