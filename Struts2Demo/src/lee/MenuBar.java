package lee;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class MenuBar extends ActionSupport {
    
    /** */
    private static final long serialVersionUID = 1L;
    
    private String parent;
    
    private String menuData;
    
    public String menu() {
        if (parent == "hai") {
            System.out.println(1111);
        }
        ArrayList<Menu> list = new ArrayList<Menu>();
        ArrayList<Menu> list1 = new ArrayList<Menu>();
        list1.add(new Menu("cmenu1", "http://www.baidu.com", false, "", "", "", false));
        list1.add(new Menu("cmenu1"));
        Menu menu1 = new Menu();
        menu1.setName("menu1");
        menu1.setChildren(list1);
        menu1.setParent(true);
        
        list.add(menu1);
        list.add(new Menu("menu2"));
        list.add(new Menu("menu3"));
        list.add(new Menu("menu4"));
        list.add(new Menu("menu5"));
        
        Gson gson = new Gson();
        menuData = gson.toJson(list);
        
        return SUCCESS;
    }
    
    public static void main(String[] args) {
        ArrayList<Menu> list = new ArrayList<Menu>();
        
        ArrayList<Menu> list1 = new ArrayList<Menu>();
        list1.add(new Menu("子menu1"));
        list1.add(new Menu("子menu2"));
        
        Menu menu1 = new Menu();
        menu1.setName("menu1");
        menu1.setChildren(list1);
        
        list.add(menu1);
        list.add(new Menu("menu2"));
        list.add(new Menu("menu3"));
        list.add(new Menu("menu4"));
        list.add(new Menu("menu5"));
        
        Gson gson = new Gson();
        String menuData = gson.toJson(list);
        menuData = menuData.replaceAll("\"name\"", "name");
        menuData = menuData.replaceAll("\"url\"", "url");
        menuData = menuData.replaceAll("\"isParent\"", "isParent");
        menuData = menuData.replaceAll("\"icon\"", "icon");
        menuData = menuData.replaceAll("\"iconClose\"", "iconClose");
        menuData = menuData.replaceAll("\"iconOpen\"", "iconOpen");
        menuData = menuData.replaceAll("\"open\"", "open");
        menuData = menuData.replaceAll("\"children\"", "children");
        System.out.println(menuData);
    }
    
    public String getParent() {
        return parent;
    }
    
    public void setParent(String parent) {
        this.parent = parent;
    }
    
    public String getMenuData() {
        return menuData;
    }
    
    public void setMenuData(String menuData) {
        this.menuData = menuData;
    }
}