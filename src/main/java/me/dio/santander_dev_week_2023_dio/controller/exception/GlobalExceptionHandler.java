package me.dio.santander_dev_week_2023_dio.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> handleBusinessException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<String> handleNotFoundException(NoSuchElementException ex) {
        return new ResponseEntity<>("Resource id not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Throwable.class)
    private ResponseEntity<String> handleUnexpectedException(Throwable ex) {
        if(ex.getClass().getTypeName().equals(NoSuchMethodError.class.getTypeName()))
            return null;
        var message = "Unexpected server error... Please, see the logs!";
        logger.error(message, ex);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
