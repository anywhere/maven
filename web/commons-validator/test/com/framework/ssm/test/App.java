package com.framework.ssm.test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.framework.ssm.validation.exception.BeanValidationFailedException;

/**
 * It is a general test class.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com"> Debadadatta Mishra (PIKU)
 * @Since Sep 2012
 */

public class App {
    
    public static void main(String[] args) {
        int noOfViolations = 0;
        Bean1 bean = new Bean1();
        bean.setAge(112);
        bean.setZipCode("12334");
        bean.setFirstName(null);
        bean.setAmount(12.345f);
        bean.setEmailId("abcd@");
        bean.setWebsite("wwww.google.");
        bean.setPassword("welcome");
        bean.setIbanActNo("AR1601101250000000012300695");
        
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Bean1>> set = validator.validate(bean);
            noOfViolations = set.size();
            if (noOfViolations != 0)
                throw new BeanValidationFailedException(set);
        } catch (BeanValidationFailedException e) {
            System.err.println("Total no of violations : " + noOfViolations);
            System.err.println(e.getMessage());
        }
    }
}
