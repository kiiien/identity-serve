package com.devteri.identity_serve.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(100, "Uncategorized Exception"),

    USER_EXISTED(510, "User already existed"),

    USER_NOT_EXISTED(400, "User not existed"),

    INVALID_KEY(410, "Invalid message key"),

    USERNAME_INVALID(400, "Username must be at least 2 characters"),

    PASSWORD_INVALID(400, "Password must be at least 2 characters"),

    UNAUTHENTICATED(500, "Un authenticated"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private  int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
