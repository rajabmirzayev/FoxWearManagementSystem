package com.library.foxwearmanagement.exception;

import com.library.foxwearmanagement.dto.ApiResponse;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<@NonNull ApiResponse<?>> handleMethodArgumentNotValidException(
            Errors errors
    ) {
        Map<String, String> err = new HashMap<>();
        errors.getFieldErrors().forEach((fieldError) ->
                err.put(fieldError.getField(), fieldError.getDefaultMessage())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.validationError(err));
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<@NonNull ApiResponse<?>> handleEmailAlreadyExistException(
            EmailAlreadyExistException exception
    ) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiResponse.alreadyExistError(exception));
    }

    @ExceptionHandler(PhoneNumberAlreadyExistException.class)
    public ResponseEntity<@NonNull ApiResponse<?>> handlePhoneNumberAlreadyExistException(
            PhoneNumberAlreadyExistException exception
    ) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiResponse.alreadyExistError(exception));
    }
}
