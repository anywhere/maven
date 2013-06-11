package struts2.spring;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class SpringTestAction implements Action, ModelDriven<UserInfo>
{
    // 用户信息
    private UserInfo userInfo = new UserInfo();
    
    // 业务处理组件类
    private MyServer ms;
    
    public String execute()
        throws Exception
    {
        if (ms.validate(getModel().getUserName(), getModel().getPassword()))
        {
            // 保存到session
            ActionContext.getContext().getSession().put("userInfo", getModel().getUserName());
            return SUCCESS;
        }
        else
        {
            return INPUT;
        }
    }
    
    public UserInfo getModel()
    {
        return this.userInfo;
    }
    
    public void setMs(MyServer ms)
    {
        this.ms = ms;
    }
}
