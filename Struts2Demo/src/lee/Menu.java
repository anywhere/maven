package lee;

import java.util.ArrayList;

public class Menu {
    
    private String name;// 目录名
    
    private String url;// url
    
    private boolean isParent;// 是不是父目录
    
    private String icon;// 图片
    
    private String iconClose;// 关闭时的图片
    
    private String iconOpen;// 打开时的图片
    
    private boolean open;// 初始化状态是不是打开的
    
    private ArrayList<Menu> children;
    
    public ArrayList<Menu> getChildren() {
        return children;
    }
    
    public void setChildren(ArrayList<Menu> children) {
        this.children = children;
    }
    
    public Menu() {
        super();
    }
    
    public Menu(String name) {
        super();
        this.name = name;
    }
    
    public Menu(String name, String url, boolean isParent, String icon, String iconClose, String iconOpen, boolean open) {
        super();
        this.name = name;
        this.url = url;
        this.isParent = isParent;
        this.icon = icon;
        this.iconClose = iconClose;
        this.iconOpen = iconOpen;
        this.open = open;
    }
    
    public boolean isParent() {
        return isParent;
    }
    
    public void setParent(boolean isParent) {
        this.isParent = isParent;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public String getIconClose() {
        return iconClose;
    }
    
    public void setIconClose(String iconClose) {
        this.iconClose = iconClose;
    }
    
    public String getIconOpen() {
        return iconOpen;
    }
    
    public void setIconOpen(String iconOpen) {
        this.iconOpen = iconOpen;
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public void setOpen(boolean open) {
        this.open = open;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
}