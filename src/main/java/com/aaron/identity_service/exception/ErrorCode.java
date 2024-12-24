package com.aaron.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User existed"),;

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
