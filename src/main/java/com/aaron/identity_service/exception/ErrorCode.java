package com.aaron.identity_service.exception;

public enum ErrorCode {
    GENERIC_ERROR(1000,"Unnamed error happened"),
    USER_EXISTED(1001, "User existed"),
    USER_NOT_EXISTED(1005, "User not existed"),
    UNCATEGORIZED_ERROR(9999, "Uncategorized error"),
    USERNAME_INVALID(1003, "username must be between 8 and 30 characters"),
    PASSWORD_INVALID(1004, "password invalid");

    private int code = 1001; // auto có thêm static final
    private String message = "Error happened";

    // auto là private constructor
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
