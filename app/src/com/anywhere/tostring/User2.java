package com.anywhere.tostring;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class User2 implements java.io.Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -6406171847732743772L;
    
    private Integer id;
    
    private String msisdn;
    
    private Date createDate;
    
    // Constructors
    /** default constructor */
    public User2()
    {
    }
    
    /** minimal constructor */
    public User2(Integer id, String msisdn, Date createDate)
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
    
    @Override
    public String toString()
    {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(this);
        return builder.toString();
    }
}