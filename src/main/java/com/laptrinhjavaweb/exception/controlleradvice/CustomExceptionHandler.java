package com.laptrinhjavaweb.exception.controlleradvice;

import com.laptrinhjavaweb.dto.response.ResponseErrorData;
import com.laptrinhjavaweb.exception.DivideByZeroException;
import com.laptrinhjavaweb.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
    private static List<String> errors = new ArrayList<>();

    @ExceptionHandler(DivideByZeroException.class) // when catch this error(DivideByZeroException) is jump into
    public ResponseEntity<Object> handleDivideByZeroException(
            DivideByZeroException ex, WebRequest request) {
        //List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        logger.error("Invalid Input Exception: ",ex.getMessage());

        ResponseErrorData body = new ResponseErrorData();
        body.setStatus("Failure!");
        body.setData(errors);

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class) // when catch this error(DivideByZeroException) is jump into
    public ResponseEntity<Object> handleNotFoundException(
            NotFoundException ex, WebRequest request) {
        //List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        logger.error("Invalid Input Exception: ",ex.getMessage());

        ResponseErrorData body = new ResponseErrorData();
        body.setStatus("Failure!");
        body.setData(errors);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
