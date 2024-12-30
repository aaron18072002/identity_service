package com.aaron.identity_service.exception;

import com.aaron.identity_service.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<Object>> handlingAppException(AppException ex) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        ErrorCode errorCode = ex.getErrorCode();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handlingRuntimeException(RuntimeException ex) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();

        ErrorCode uncategorizedErrorCode = ErrorCode.UNCATEGORIZED_ERROR;

        apiResponse.setCode(uncategorizedErrorCode.getCode());
        apiResponse.setMessage(uncategorizedErrorCode.getMessage());

        return ResponseEntity.status(uncategorizedErrorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Object>> handlingAccessDeniedException(AccessDeniedException ex) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        ErrorCode forbiddenError = ErrorCode.UNAUTHORIZED;

        apiResponse.setCode(forbiddenError.getCode());
        apiResponse.setMessage(forbiddenError.getMessage());

        return ResponseEntity.status(forbiddenError.getStatusCode())
                .body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handlingValidationException(MethodArgumentNotValidException ex) {
        ErrorCode errorCode;

        String emumKey = ex.getFieldError().getDefaultMessage();
        try {
            errorCode = ErrorCode.valueOf(emumKey);
        } catch (IllegalArgumentException e) {
            errorCode = ErrorCode.GENERIC_ERROR;
        }

        ApiResponse<Object> apiResponse = new ApiResponse<>();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

}
