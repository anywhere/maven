package com.framework.ssm.pojo;

@SuppressWarnings("serial")
public class Node extends BaseObject implements Cloneable {
    
    protected String area;
    
    protected int count = 0;
    
    protected String iconSkin;
    
    protected String id;
    
    protected String image;
    
    protected String name;
    
    protected String pid;
    
    protected String remark;
    
    // protected int isParent;// 是不是父节点
    
    protected String sort;
    
    protected Integer status = 0;
    
    protected String type;
    
    public String getArea() {
        return area;
    }
    
    public int getCount() {
        return count;
    }
    
    public String getIconSkin() {
        return iconSkin;
    }
    
    public String getId() {
        return id;
    }
    
    public String getImage() {
        return image;
    }
    
    public int getIsParent() {
        return 0;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPid() {
        return pid;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public String getSort() {
        return sort;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public String getType() {
        return type;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public void setSort(String sort) {
        this.sort = sort;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Object clone() {
        try {
            Node obj = (Node) super.clone();
            return obj;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
