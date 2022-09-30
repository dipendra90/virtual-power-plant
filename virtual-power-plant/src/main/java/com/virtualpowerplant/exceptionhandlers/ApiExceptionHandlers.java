package com.virtualpowerplant.exceptionhandlers;

import com.virtualpowerplant.base.BaseResponse;
import com.virtualpowerplant.exceptionhandlers.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandlers {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<BaseResponse> handleEntityNotFoundException(EntityNotFoundException exception) {
        BaseResponse response = new BaseResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
