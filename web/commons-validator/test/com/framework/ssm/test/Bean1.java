package com.framework.ssm.test;

import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import com.framework.ssm.validation.constraints.IBAN;
import com.framework.ssm.validation.constraints.Password;

/**
 * This is a POJO with the fields provided with annotations for the validations. This java bean class contains javax
 * annotations, hibernate provided annotations and custom defined annotations.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com"> Debadadatta Mishra (PIKU)
 * @Since Sep 2012
 */

public class Bean1 {
    
    // ~~~~~~~~~~ javax annotations for validation ~~~~~~~~~~
    
    @Digits(integer = 2, fraction = 0, message = "The value of age can not be more than 2 digits")
    @Min(value = 18, message = "The minimum age should be 18")
    @Max(value = 50, message = "The maximum age can not more than be 50")
    private int age;
    
    @NotNull(message = "First Name can not be null ... ")
    private String firstName;
    
    @DecimalMax(value = "99999.999", message = "The decimal value can not be more than 99999.999 ")
    @DecimalMin(value = "1.00", message = "The decimal value can not be less than 1.00 digit ")
    private float amount = 0f;
    
    @NotNull
    @Pattern(regexp = "^\\d{6}", message = "Invalid zip code, Indian zip code should be 6 digit")
    private String zipCode;
    
    // ~~~~~~~~~~ Hibernate provided annotations for validation ~~~~~~~~~~
    
    @CreditCardNumber(message = "Invalid credit card number")
    private String creditCard;
    
    @Email(message = "Invalid email id")
    private String emailId;
    
    @Length(max = 50, min = 10, message = "The message description should be within 10 to 50 characters")
    private String description;
    
    @NotBlank(message = "SurName can not be blank")
    // It is only applicable to String
    private String surName;
    
    @NotEmpty(message = "The list can not be empty")
    private List<String> countryList;
    
    @URL(message = "Invalid website address")
    private String website;
    
    // ~~~~~~~~~~ Custom annotations for validation ~~~~~~~~~~
    
    @Password
    private String password;
    
    @IBAN
    private String ibanActNo;
    
    // ~~ getter and setter methods below
    
    public String getIbanActNo() {
        return ibanActNo;
    }
    
    public void setIbanActNo(String ibanActNo) {
        this.ibanActNo = ibanActNo;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public float getAmount() {
        return amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getCreditCard() {
        return creditCard;
    }
    
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
    
    public String getEmailId() {
        return emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getSurName() {
        return surName;
    }
    
    public void setSurName(String surName) {
        this.surName = surName;
    }
    
    public List<String> getCountryList() {
        return countryList;
    }
    
    public void setCountryList(List<String> countryList) {
        this.countryList = countryList;
    }
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
}
