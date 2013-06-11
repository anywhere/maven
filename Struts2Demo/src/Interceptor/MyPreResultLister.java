package Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class MyPreResultLister implements PreResultListener 
{

    public void beforeResult(ActionInvocation arg0, String arg1)
    {
        System.out.println("拦截器监听");
        // TODO Auto-generated method stub
        
    }

}
