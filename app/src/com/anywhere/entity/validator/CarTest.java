package com.anywhere.entity.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class CarTest {
    
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Car car = new Car(null, "", 1);
        Person driver = new Person();
        driver.setAge(12);
        driver.setName("");
        car.setDriver(driver);
        
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        
        for (ConstraintViolation<Car> constraintViolation : constraintViolations) {
            System.err.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getPropertyPath());
        }
        
    }
}
