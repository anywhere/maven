package lee;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import com.google.gson.Gson;

public class JsonTestAction extends ActionSupport {
    
    /** */
    private static final long serialVersionUID = 1L;
    
    private String data;// json
    
    public String jsonExcute() {
        ArrayList<Data> list = new ArrayList<Data>();
        list.add(new Data("1", 1000, 1200));
        list.add(new Data("2", 800, 1000));
        list.add(new Data("3", 9000, 9800));
        list.add(new Data("4", 1100, 1500));
        list.add(new Data("5", 1500, 1110));
        list.add(new Data("6", 1060, 1500));
        list.add(new Data("7", 1030, 1040));
        list.add(new Data("8", 1200, 1100));
        list.add(new Data("9", 1100, 900));
        list.add(new Data("10", 1100, 800));
        Gson gson = new Gson();
        data = gson.toJson(list);
        return SUCCESS;
    }
    
    public String test() {
        return SUCCESS;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
}
