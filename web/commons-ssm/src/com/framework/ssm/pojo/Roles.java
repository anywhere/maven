package com.framework.ssm.pojo;

import java.util.Date;
import java.util.List;

import com.framework.ssm.util.Constants;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:19:13 PM
 * <ul>
 * <li>comment:Roles entity.</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class Roles extends BaseObject {
    
    private Date createDate;
    
    private String id;
    
    private String name;
    
    private String remarks;
    
    private List<Resources> resources;
    
    /** default constructor */
    public Roles() {
    }
    
    /** full constructor */
    public Roles(String name, String remarks, Date createDate, List<Resources> resources) {
        this.name = name;
        this.remarks = remarks;
        this.createDate = createDate;
        this.resources = resources;
    }
    
    // Property accessors
    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Roles other = (Roles) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    public String getAuthority() {
        return Constants.ROLE_PREFIX + getId();
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getRemarks() {
        return this.remarks;
    }
    
    public List<Resources> getResources() {
        return resources;
    }
    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public void setResources(List<Resources> resources) {
        this.resources = resources;
    }
    
}