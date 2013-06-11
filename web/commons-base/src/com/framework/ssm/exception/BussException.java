/**
 * 
 */
package com.framework.ssm.exception;

@SuppressWarnings("serial")
public class BussException extends RuntimeException {
    
    private int errorCode;
    
    private String message;
    
    // private ResourceMessage defaultMessage;
    
    private Object[] args;
    
    // public BussException(int errorCode) {
    // this(errorCode, null);
    // this.errorCode = errorCode;
    // }
    //
    // public BussException(int errorCode, ResourceMessage message) {
    // this("code." + errorCode, message);
    // }
    //
    // public BussException(int errorCode, ResourceMessage defaultMessage, Object... args) {
    // this("code." + errorCode, defaultMessage, args);
    // }
    
    public BussException(String message) {
        // this(message, "");
        this.message = message;
    }
    
    public BussException(String message, Object... args) {
        // super(message);
        this.message = message;
        this.args = args;
    }
    
    // public BussException(String message, ResourceMessage defaultMessage, Object... args) {
    // this(message, args);
    // this.defaultMessage = defaultMessage;
    // }
    
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
    
    // public ResourceMessage getDefaultMessage() {
    // return defaultMessage;
    // }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}