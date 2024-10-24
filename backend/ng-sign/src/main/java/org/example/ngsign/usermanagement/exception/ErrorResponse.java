package org.example.ngsign.usermanagement.exception;

import java.util.List;

public class ErrorResponse {
    private String message;
    private ErrorCodes errorCode;
    private List<String> errors;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCodes errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
