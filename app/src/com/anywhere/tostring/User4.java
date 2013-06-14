package com.anywhere.tostring;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class User4 extends Client implements java.io.Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -4689195680179094092L;
    
    private Integer id;
    
    private String msisdn;
    
    private Date createDate;
    
    // Constructors
    /** default constructor */
    public User4()
    {
    }
    
    /** minimal constructor */
    public User4(Integer id, String msisdn, Date createDate)
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
        return ToStringBuilder.reflectionToString(this);
    }
    
}