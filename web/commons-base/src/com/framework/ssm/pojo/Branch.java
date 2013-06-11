package com.framework.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Branch extends Node {
    
    protected List<Node> children = new ArrayList<Node>();
    
    protected String iconClose;// 关闭时的图片
    
    protected String iconOpen;// 打开时的图片
    
    protected boolean open;
    
    public int count() {
        int count = 0;
        if (null != children && !children.isEmpty())
            for (Node child : children) {
                count += child.getCount();
            }
        return count;
    }
    
    public List<Node> getChildren() {
        return children;
    }
    
    public String getIconClose() {
        return iconClose;
    }
    
    public String getIconOpen() {
        return iconOpen;
    }
    
    public int getIsParent() {
        return 1;
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public void setChildren(List<Node> children) {
        this.children = children;
    }
    
    public void setIconClose(String iconClose) {
        this.iconClose = iconClose;
    }
    
    public void setIconOpen(String iconOpen) {
        this.iconOpen = iconOpen;
    }
    
    public void setOpen(boolean open) {
        this.open = open;
    }
    
    public int status() {
        int status = 0;
        if (null != children && !children.isEmpty()) {
            for (Node child : children) {
                int stat = child.getStatus();
                if (stat > status) {
                    status = stat;
                }
            }
        }
        return status;
    }
    
    public Object clone() {
        Branch obj = (Branch) super.clone();
        List<Node> list = new ArrayList<Node>();
        for (Node city : this.children) {
            list.add((Node) city.clone());
        }
        obj.children = list;// 这句是关键
        return obj;
    }
    
}
