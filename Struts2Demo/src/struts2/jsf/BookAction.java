package struts2.jsf;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

public class BookAction extends ActionSupport
{
    private Book currentBook;
    private int editId;

    private BookService bs;
    public void setBs(BookService bs)
    {
        this.bs = bs;
    }

    public void setCurrentBook(Book currentBook)
    {
        this.currentBook = currentBook;
    }
    public Book getCurrentBook()
    {
        //如果editId请求参数不为空，则currentBook也不为空
        if (editId != 0)
        {
            this.currentBook = bs.getBookById(editId);
        }
        else if (currentBook == null)
        {
            currentBook = new Book();
        }
        return this.currentBook;
    }

    public void setEditId(int editId)
    {
        this.editId = editId;
    }
    public int getEditId()
    {
         return this.editId;
    }

    public List<Book> getAllBook()
    {
        List<Book> result = new ArrayList<Book>();
        for (Book b : bs.getAllBook())
        {
            result.add(b);
        }
        return result;
    }

    public String save()
    {
        bs.addBook(currentBook);
        return "list";
    }

}