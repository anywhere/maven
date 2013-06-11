package struts2.action;

import service.BookService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class BookAction implements Action, ModelDriven<Book>
{
    private Book book = new Book();
    
    public String execute()
        throws Exception
    {
        String userInfo = (String)ActionContext.getContext().getSession().get("userInfo");
        
        if (userInfo != null)
        {
            BookService bookService = new BookService();
            getModel().setBooks(bookService.getBook());
            return SUCCESS;
        }
        else
        {
            return LOGIN;
        }
    }
    
    // 使用ModelDriven接口中的getModel()方法获取属性
    public Book getModel()
    {
        return book;
    }
}
