package com.mehmethalman.shipmentservice.exception;

import com.mehmethalman.shipmentservice.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        ErrorResponseDto error = new ErrorResponseDto("NOT_FOUND_ERROR", e.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGeneralException(Exception e) {
        ErrorResponseDto error = new ErrorResponseDto("INTERNAL_SERVER_ERROR", e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
