package com.anywhere.tostring;

import java.util.Date;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class User implements java.io.Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -7604990735735437340L;
    
    private Integer id;
    
    private String msisdn;
    
    private Date createDate;
    
    // Constructors
    /** default constructor */
    public User()
    {
    }
    
    /** minimal constructor */
    public User(Integer id, String msisdn, Date createDate)
    {
        this.id = id;
        this.msisdn = msisdn;
        this.createDate = createDate;
    }
    
    // Property accessors
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getMsisdn()
    {
        return msisdn;
    }
    
    public void setMsisdn(String msisdn)
    {
        this.msisdn = msisdn;
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
    
}