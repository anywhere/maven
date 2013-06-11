package Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 方法过滤时，继承MethodFilterInterceptor类
 * @author Administrator
 *
 */
public class MyFilterInterceptor extends MethodFilterInterceptor 
{
    @Override
    protected String doIntercept(ActionInvocation arg0) throws Exception 
    {
        System.out.println("拦截器动作。start");
        //将一个拦截结果的监听器注册给该拦截器
        arg0.addPreResultListener(new MyPreResultLister());
        String result = arg0.invoke();
        
        System.out.println("拦截器动作。end");
        return result;
    }

}
