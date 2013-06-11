package struts2.jsf;

import java.util.*;

public class BookService
{
    //保存程序的状态
    private Set<Book> bookDb;
    //初始化数据
    public BookService()
    {
        bookDb = new HashSet<Book>();
        bookDb.add(new Book(1 ,"Spring2.0宝","全面介绍了Spring各个知识点"));
        bookDb.add(new Book(2 , "轻量级J2EE企业应用实战","全面介绍企业的J2EE开发过程"));
    }
    //列出所有图书
    public Set<Book> getAllBook()
    {
        return bookDb;
    }
    //根据主键取得相应的图书
    public Book getBookById(int id)
    {
        for (Book b : bookDb)
        {
            if (b.getId() == id)
            {
                return b;
            }
        }
        return null;
    }
    //增加图书
    public void addBook(Book b)
    {
        bookDb.add(b);
    }
}