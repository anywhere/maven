package com.anywhere.tostring;

import java.util.Date;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class User1 extends User implements java.io.Serializable
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
    public User1()
    {
    }
    
    /** minimal constructor */
    public User1(Integer id, String msisdn, Date createDate)
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
        StringBuffer sb = new StringBuffer();
        sb.append("[").append(this.getClass().getSimpleName());
        sb.append(":id=").append(id);
        sb.append(", msisdn=").append(msisdn);
        sb.append(", createDate=").append(createDate).append("]");
        return sb.toString();
    }
}