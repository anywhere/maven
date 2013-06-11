package struts2.jsf;

public class Book
{
    private int id;
    
    private String name;
    
    private String desc;
    
    public Book()
    {
    }
    
    public Book(int id, String name, String desc)
    {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    
    public String getDesc()
    {
        return this.desc;
    }
    
    // 根据Book实例的id取得对应的hashCode
    public int hashCode()
    {
        return id;
    }
    
    // 重写equals方法，根据Book实例的id属性判断二个实例是否相等
    public boolean equals(Object target)
    {
        if (target instanceof Book)
        {
            Book b = (Book)target;
            if (b.getId() == this.id)
            {
                return true;
            }
        }
        return false;
    }
}