package struts2.spring;

/**
 * 
 * <登录业务> <登录业务实现类，检查用户是否正确>
 */
public class MyServerImp implements MyServer
{
    public boolean validate(String userName, String password)
    {
        if (userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
