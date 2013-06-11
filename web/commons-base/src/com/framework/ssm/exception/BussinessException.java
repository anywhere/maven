package com.framework.ssm.exception;

@SuppressWarnings("serial")
public class BussinessException extends RuntimeException {
    
    private Object[] args;
    
    private BussinessException[] errors;
    
    private int errorCode;
    
    public BussinessException(int errorCode) {
        this(errorCode, "");
        this.errorCode = errorCode;
    }
    
    public BussinessException(int errorCode, Object... args) {
        this("code." + errorCode, args);
    }
    
    public BussinessException(String message) {
        super(message);
        // this.message = message;
    }
    
    public BussinessException(String message, Object... args) {
        super(message);
        this.args = args;
    }
    
    public BussinessException(String message, BussinessException... errors) {
        this(message, "");
        this.errors = errors;
    }
    
    public BussinessException[] getErrors() {
        return errors;
    }
    
    public Object[] getArgs() {
        return args;
    }
    
    public int getErrorCode() {
        return errorCode;
    }
    
}