package com.anywhere.entity.validator;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car {

    @NotNull(message = "制造商不能为空")
    private String manufacturer;
    
    @NotNull(message = "大小不能为空")
    @Size(min = 2, max = 14, message = "长度应该介于2和14之间")
    private String licensePlate;
    
    @Min(value = 2, message = "座位数最少为2个")
    private int seatCount;
    
    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }
    
    @NotNull
    @Valid
    private Person driver;
    
    public Person getDriver() {
        return driver;
    }
    
    public void setDriver(Person driver) {
        this.driver = driver;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public int getSeatCount() {
        return seatCount;
    }
    
    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
    
}