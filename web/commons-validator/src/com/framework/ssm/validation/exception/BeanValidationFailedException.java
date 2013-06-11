package com.framework.ssm.validation.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * This is a custom exception class to handle the exception related to bean validation.
 * 
 * @author jinyifeng5969@163.com QQ:361612388
 * @since 2013-6-3
 * @description
 * @TODO
 */
@SuppressWarnings("serial")
public class BeanValidationFailedException extends RuntimeException {
    
    private Set<?> validationSet;
    
    private Map<String, List<String>> errorMap;
    
    public BeanValidationFailedException(final Set<?> set) {
        super();
        this.validationSet = set;
    }
    
    public void printStackTrace() {
        Iterator<?> it = validationSet.iterator();
        while (it.hasNext()) {
            ConstraintViolation<?> constViolation = (ConstraintViolation<?>) it.next();
            System.err.println("Constraint Message ::: " + constViolation.getMessage());
            System.err.println("Invalid Value ::: " + constViolation.getInvalidValue());
        }
    }
    
    public String getMessage() {
        StringBuilder msg = new StringBuilder();
        Iterator<?> it = validationSet.iterator();
        while (it.hasNext()) {
            ConstraintViolation<?> cv = (ConstraintViolation<?>) it.next();
            // msg.append(cv.getMessage()).append(" - ").append("invalid entry ").append(cv.getInvalidValue())
            // .append("\n");
            msg.append(cv.getMessage()).append("\n");
        }
        return msg.toString();
    }
    
    public Set<?> getValidationSet() {
        return validationSet;
    }
    
    public Map<String, List<String>> getErrorMap() {
        List<String> list;
        errorMap = new HashMap<String, List<String>>();
        Iterator<?> it = validationSet.iterator();
        while (it.hasNext()) {
            ConstraintViolation<?> cv = (ConstraintViolation<?>) it.next();
            list = new ArrayList<String>();
            list.add(cv.getMessage());
            errorMap.put(cv.getPropertyPath().toString(), list);
        }
        return errorMap;
    }
}