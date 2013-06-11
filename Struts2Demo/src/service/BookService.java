package service;

public class BookService
{
    private String[] book = new String[] {"struts2入门", "hibernate入门", "spring入门"};
    
    public String[] getBook()
    {
        return this.book;
    }
    
    public Book[] getBooks()
    {
        return new Book[] {new Book("Spring2.0宝典", "李刚"), new Book("轻量级J2EE企业应用实战", "李刚"),
            new Book("基于J2EE的Ajax宝典", "李刚")};
    }
}
