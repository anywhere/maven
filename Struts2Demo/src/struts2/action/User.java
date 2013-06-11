package struts2.action;

import java.util.Date;

public class User
{
    private String userName;
    
    private String password;
    
    private int age;
    
    private Date birthDate;
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public Date getBirthDate()
    {
        return birthDate;
    }
    
    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }
}
