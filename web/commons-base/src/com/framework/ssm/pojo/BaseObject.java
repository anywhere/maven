package com.framework.ssm.pojo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.framework.ssm.page.Page;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:17:55 PM
 * <ul>
 * <li>comment:Entity bean BaseObject</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class BaseObject implements Serializable {
    
    private String columnName;
    
    private String orderType = "desc";
    
    private Page page;
    
    public String getColumnName() {
        return columnName;
    }
    
    public String getOrderType() {
        return orderType;
    }
    
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    
    public Page getPage() {
        return page;
    }
    
    public void setPage(Page page) {
        this.page = page;
    }
    
    public String toString() {
        try {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}