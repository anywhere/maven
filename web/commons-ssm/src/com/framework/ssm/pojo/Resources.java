package com.framework.ssm.pojo;

import java.util.Date;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:18:38 PM
 * <ul>
 * <li>comment:Resource entity.</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class Resources extends BaseObject {
    
    private Date createDate;
    
    private Integer currentLevel;
    
    private Integer currentOrder;
    
    private Integer fixed;
    
    private String iconSkin;
    
    // Fields
    // --------------Menu Properties----------------
    private String id;
    
    private Integer isMenu;
    
    // ----------------Menu Properties--------------
    
    private boolean isOpen;
    
    private Integer isParent;// 是不是父节点
    
    private String name;
    
    private String permit;
    
    private String pid;
    
    private String rootId;
    
    private String targetId;
    
    private Integer type;
    
    private String url;
    
    private Integer visiable;
    
    /** default constructor */
    public Resources() {
    }
    
    /** full constructor */
    public Resources(Integer type, String rootId, Integer currentOrder, Integer currentLevel, Integer visiable,
            String permit, String targetId, Integer isMenu, Date createDate) {
        this.type = type;
        this.rootId = rootId;
        this.currentOrder = currentOrder;
        this.currentLevel = currentLevel;
        this.visiable = visiable;
        this.permit = permit;
        this.targetId = targetId;
        this.isMenu = isMenu;
        this.createDate = createDate;
    }
    
    // Property accessors
    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resources other = (Resources) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public Integer getCurrentLevel() {
        return this.currentLevel;
    }
    
    public Integer getCurrentOrder() {
        return this.currentOrder;
    }
    
    public Integer getFixed() {
        return fixed;
    }
    
    public String getIconSkin() {
        return iconSkin;
    }
    
    public String getId() {
        return id;
    }
    
    public Integer getIsMenu() {
        return isMenu;
    }
    
    public Integer getIsParent() {
        return isParent;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPermit() {
        return this.permit;
    }
    
    public String getPid() {
        return pid;
    }
    
    // public String getPId() {
    // return pid;
    // }
    
    public String getRootId() {
        return this.rootId;
    }
    
    public String getTargetId() {
        return this.targetId;
    }
    
    public Integer getType() {
        return this.type;
    }
    
    public String getUrl() {
        return url;
    }
    
    public Integer getVisiable() {
        return this.visiable;
    }
    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
    
    public boolean isOpen() {
        return isOpen;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }
    
    public void setCurrentOrder(Integer currentOrder) {
        this.currentOrder = currentOrder;
    }
    
    public void setFixed(Integer fixed) {
        this.fixed = fixed;
    }
    
    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }
    
    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    public void setPermit(String permit) {
        this.permit = permit;
    }
    
    public void setPid(String pId) {
        this.pid = pId;
    }
    
    public void setPId(String pId) {
        this.pid = pId;
    }
    
    public void setRootId(String rootId) {
        this.rootId = rootId;
    }
    
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void setVisiable(Integer visiable) {
        this.visiable = visiable;
    }
    
}