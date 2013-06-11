package com.framework.ssm.exception;

@SuppressWarnings("serial")
public class BussinessException2 extends RuntimeException {
    
    private int errorCode;
    
    private String message;
    
    private String defaultMessage;
    
    private Object[] args;
    
    private BussinessException2[] errors;
    
    public BussinessException2(int errorCode) {
        this(errorCode, "");
        this.errorCode = errorCode;
    }
    
    public BussinessException2(int errorCode, Object... args) {
        this("code." + errorCode, args);
    }
    
    public BussinessException2(int errorCode, String defaultMessage, Object... args) {
        this("code." + errorCode, args);
        this.defaultMessage = defaultMessage;
    }
    
    public BussinessException2(String message) {
        this(message, "");
        // this.message = message;
    }
    
    public BussinessException2(String message, Object... args) {
        super(message);
        this.message = message;
        this.args = args;
    }
    
    public BussinessException2(String message, String defaultMessage, Object... args) {
        this(message, args);
        this.defaultMessage = defaultMessage;
    }
    
    public BussinessException2(String message, BussinessException2... errors) {
        this(message, "");
        this.errors = errors;
    }
    
    public BussinessException2[] getErrors() {
        return errors;
    }
    
    public Object[] getArgs() {
        return args;
    }
    
    public int getErrorCode() {
        return errorCode;
    }
    
    public String getMessage() {
        // return super.getMessage();
        return message;
    }
    
}