package com.anywhere.tostring;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class User3 extends Client implements java.io.Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 4074895406342395984L;
    
    private Integer id;
    
    private String msisdn;
    
    private Date createDate;
    
    // Constructors
    /** default constructor */
    public User3()
    {
    }
    
    /** minimal constructor */
    public User3(Integer id, String msisdn, Date createDate)
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
        ToStringBuilder tb = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        tb.append("id", id);
        tb.append("msisdn", msisdn);
        tb.append("createDate", createDate);
        return tb.toString();
    }
}