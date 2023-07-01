package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

    //TODO:: implement handler methods for FizzException, BuzzException and FizzBuzzException

    @ExceptionHandler(value
            = {FizzException.class})
    protected ResponseEntity<Object> handleFizzException(
            FizzException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex);
    }

    @ExceptionHandler(value
            = {BuzzException.class})
    protected ResponseEntity<Object> handleBuzzException(
            BuzzException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex);
    }

    @ExceptionHandler(value
            = {FizzBuzzException.class})
    protected ResponseEntity<Object> handleFizzBuzzException(
            FizzBuzzException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.INSUFFICIENT_STORAGE)
                .body(ex);
    }
}
