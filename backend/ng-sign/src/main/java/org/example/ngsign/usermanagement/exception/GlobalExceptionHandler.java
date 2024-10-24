package org.example.ngsign.usermanagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEntityException(InvalidEntityException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setErrorCode(ex.getErrorCode());
        errorResponse.setErrors(ex.getErrors());

        return ResponseEntity.badRequest().body(errorResponse);
    }
}
