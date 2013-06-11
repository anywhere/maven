package com.anywhere.entity.validator;

import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

public class Person {
    
    @NotBlank(message = "name can not be blank")
    String name;
    
    @Min(value = 18, message = "年龄最小18岁")
    int age;
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}