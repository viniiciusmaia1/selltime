package com.br.viniciusmaiacommerce.selltime.handler;

import com.br.viniciusmaiacommerce.selltime.model.error.ErrorMessage;import com.br.viniciusmaiacommerce.selltime.model.exception.ResourceNotFoundException;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {
    ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), exception.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
