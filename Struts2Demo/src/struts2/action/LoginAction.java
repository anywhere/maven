package struts2.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import MyException.MyException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 如果需要进行数据验证，所以该Action继承ActionSupport(已经继承Action)， 否则实现Action接口即可
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<User>, ServletRequestAware {
    
    private HttpServletRequest request;
    
    // 把属性封装到JavaBean中，需要Struts2自动填充值，则需要实现ModelDriven这个
    private User user = new User();
    
    // 处理用户请求
    public String execute() throws Exception {
        if (getModel().getUserName().equalsIgnoreCase("user")) {
            throw new MyException("自定义异常");
        } else if (getModel().getUserName().equalsIgnoreCase("sql")) {
            throw new MyException("用户名不能为sql");
        }
        
        if ("admin".equalsIgnoreCase(getModel().getUserName()) && "admin".equalsIgnoreCase(getModel().getPassword())) {
            // 保存到session
            ActionContext.getContext().getSession().put("userInfo", getModel().getUserName());
            request.setAttribute("hello", "hello");
            // 输入占位符的国际化信息
            System.out.println("用户名： " + getText("succTip", new String[] { getModel().getUserName() }));
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
    
    // 使用ModelDriven接口中的getModel()方法获取属性
    public User getModel() {
        return user;
    }
    
    // 注册使用
    public String register() throws Exception {
        System.out.println(getModel().getUserName() + " : " + getModel().getAge() + "  : " + getModel().getBirthDate());
        // ActionContext.getContext().getSession().put("userInfo" , getModel().getUserName());
        Map<String, Object> map = ActionContext.getContext().getSession();
        map.put("userInfo", getModel().getUserName());
        return SUCCESS;
    }
    
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
        
    }
    
    /**
     * 换一种方法实现数据验证
     */
    // public void validate() {
    // // getText()获取资源文件信息，做国际化处理
    // if (getModel().getUserName() == null || getModel().getUserName().trim().equals("")) {
    // addFieldError("userName", getText("userName.error"));
    // }
    // if (getModel().getPassword() == null || getModel().getPassword().trim().equals("")) {
    // addFieldError("password", getText("password.error"));
    // }
    // }
}