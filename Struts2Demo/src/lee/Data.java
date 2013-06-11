package lee;

import java.io.Serializable;

public class Data implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2514843183976596070L;
    
    private String month;
    
    private int forecast;
    
    private int income;
    
    public String getMonth() {
        return month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }
    
    public Data(String month, int forecast, int income) {
        super();
        this.month = month;
        this.forecast = forecast;
        this.income = income;
    }
    
    public int getForecast() {
        return forecast;
    }
    
    public void setForecast(int forecast) {
        this.forecast = forecast;
    }
    
    public int getIncome() {
        return income;
    }
    
    public void setIncome(int income) {
        this.income = income;
    }
    
}