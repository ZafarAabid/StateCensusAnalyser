package com.statecensus;

public class CustomException extends Exception {

    ExceptionType type;

    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FILE, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS, OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE, NO_ACCESS, BINDING_PROBLEM_AT_RUNTIME
    }

    public CustomException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public CustomException(ExceptionType type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
