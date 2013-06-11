package struts2.ajax.json;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;

public class JSONExample
{
    private int[] ints = {10, 20};
    
    private Map map = new HashMap();
    
    private String customName = "custom";
    
    private String field1;
    
    // 'transient'不会被序列化
    private transient String field2;
    
    // 没有setter和getter方法的字段不会被序列化
    private String field3;
    
    public String execute()
    {
        map.put("name", "yeeku");
        return Action.SUCCESS;
    }
    
    public String getField1()
    {
        return field1;
    }
    
    public void setField1(String field1)
    {
        this.field1 = field1;
    }
    
    public String getField2()
    {
        return field2;
    }
    
    public void setField2(String field2)
    {
        this.field2 = field2;
    }
    
    public String getField3()
    {
        return field3;
    }
    
    public void setField3(String field3)
    {
        this.field3 = field3;
    }
    
    public int[] getInts()
    {
        return ints;
    }
    
    public void setInts(int[] ints)
    {
        this.ints = ints;
    }
    
    public Map getMap()
    {
        return map;
    }
    
    public void setMap(Map map)
    {
        this.map = map;
    }
    
    /*
     * 使用注释语法来改变属性序列后的后的属性名 JSON注释还包含 Serialize:设置是否序列化该属性 deserialize:设置是否反序列化该属性
     * format:用户格式化输出、解释日期表单域的格式，格式为：yyyy-MM-dd'T'HH:mm:SS
     */
    @JSON(name = "newName")
    public String getCustomName()
    {
        return this.customName;
    }
}