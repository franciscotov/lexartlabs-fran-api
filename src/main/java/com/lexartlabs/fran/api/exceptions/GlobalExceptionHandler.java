package com.lexartlabs.fran.api.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleGeneralExceptions(Exception ex) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorsMap().get(ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<String> handleRuntimeExceptions(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorsMap().get(ex.getMessage()));
    }

    @ExceptionHandler(InvalidJwtException.class)
    public ResponseEntity<String> handleJwtErrors(InvalidJwtException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsMap().get(ex.getMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsError(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorsMap().get(ex.getMessage()));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotFoundError(ProductNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", errorsMap().get(ex.getMessage()));
        response.put("productId", ex.getId());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    private Map<String, String> errorsMap() {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("errors", "errors");
        errorResponse.put("not_found_product", "Product not found");
        return errorResponse;
    }
}