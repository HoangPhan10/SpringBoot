package com.example.SpringMVC.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private FieldError err;

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String,String> conflictData(Exception ex){
        logger.info(ex.getMessage());
        Map<String,String> map = new HashMap<>();
        map.put("code","409");
        map.put("error","conflict data");
        return  map;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Map<String,String> methodNotSupportedException(Exception ex){
        logger.info(ex.getMessage());
        Map<String,String> map = new HashMap<>();
        map.put("code","403");
        map.put("error","Method not allowed");
        return  map;
    }
    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  Map<String, String> notValidException(MethodArgumentNotValidException ex){
        logger.info(ex.getMessage());
        Map<String,String> map = new HashMap<>();
        map.put("code","400");
        ex.getBindingResult().getFieldErrors().forEach(err->{
            map.put(err.getField(),err.getDefaultMessage());
        });
        return  map;
    }
}
