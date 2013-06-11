package com.framework.ssm.web.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.framework.ssm.exception.BussinessException;
import com.framework.ssm.page.Page;
import com.framework.ssm.pojo.Resources;
import com.framework.ssm.security.AcegiUtils;
import com.framework.ssm.util.ErrorCode;
import com.framework.ssm.validation.exception.BeanValidationFailedException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:06:33 PM
 * <ul>
 * <li>comment:简单封装xwork ActionSupport的基类. 提供一些基本的简化函数,将不断增强.</li>
 * <ul>
 */
@SuppressWarnings({ "serial" })
public abstract class StrutsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware,
        ErrorCode {
    
    /** 跳转列表结果的字符串 */
    protected final String LIST = "list";
    
    protected HttpServletRequest request;
    
    protected HttpServletResponse response;
    
    protected HttpSession session;
    
    protected String json;
    
    protected List list;
    
    protected Page page = new Page();
    
    @Resource
    private ResourceBundleMessageSource resource;
    
    /**
     * @param aTextName 消息在资源文件配置的key
     */
    protected final void addError(String aTextName) {
        addActionError(getText(aTextName));
    }
    
    /**
     * @param aTextName 消息在资源文件配置的key
     */
    protected final void addMsg(String aTextName) {
        addActionMessage(getText(aTextName));
    }
    
    /**
     * @param errorMap 消息在资源文件配置的key
     */
    protected final void addValidationError(Map<String, List<String>> errorMap) {
        // addFieldError(fieldName, getText(errorMessage));
        setFieldErrors(errorMap);
    }
    
    /**
     * 子类需要实现的方法
     * 
     * <ul>
     * <li>author jinyifeng5969@163.com</li>
     * <li>createDate: 2013-6-7 下午10:24:53</li>
     * </ul>
     * 
     * @return
     * @throws Exception
     */
    protected abstract String exec() throws Exception;
    
    /**
     * 请求入口,子类不能重写该方法
     */
    public final String execute() throws Exception {
        try {
            session = request.getSession();
            if (AcegiUtils.hasLogin()) {
                return this.exec();
            }
            return LOGIN;
        } catch (BussinessException e) {
            addError(getMessage(e.getMessage(), e.getArgs()));
            return ERROR;
        } catch (BeanValidationFailedException e) {
            addError(e.getMessage());
            // addValidationError(e.getErrorMap());
            return INPUT;
        } catch (IllegalArgumentException e) {
            // addError(getMessage(e.getMessage()));
            addError(e.getMessage());
            // response.sendRedirect(request.getHeader("Referer"));
            return INPUT;
        }// 其它异常交给框架去处理
    }
    
    protected final String getMessage(String code) {
        try {
            return resource.getMessage(code, null, getLocale());
        } catch (NoSuchMessageException e) {
            LOG.debug(e.getMessage(), e);
            return code;
        }
    }
    
    protected final String getMessage(String code, Object[] args) {
        if (null != args) {
            for (int i = 0; i < args.length; i++) {
                try {
                    args[i] = resource.getMessage(args[i].toString(), null, getLocale());
                } catch (NoSuchMessageException ne) {
                    LOG.debug(ne.getMessage());
                }
            }
        }
        try {
            return resource.getMessage(code, args, getLocale());
        } catch (NoSuchMessageException ne) {
            // LOG.debug(ne.getMessage());
            return code;
        }
        
        // try {
        // // 如果参数大于1个，说明有错误值传入
        // if (null != args && args.length >= 1) {
        // try {
        // args[0] = resource.getMessage((String) args[0], null, getLocale());
        // } catch (NoSuchMessageException e) {
        // LOG.debug(e.getMessage(), e);
        // }
        // }
        // return resource.getMessage(code, args, getLocale());
        // } catch (NoSuchMessageException e) {
        // LOG.debug(e.getMessage(), e);
        // return code;
        // }
    }
    
    public String getPath(Map<String, Resources> map, String menuId, String path) {
        Resources resource = map.get(menuId);
        path = "<a href='" + resource.getUrl() + "'>" + resource.getName() + "</a>" + "&gt" + path;
        String pid = resource.getPid();
        if (!pid.equals("0")) {
            path = getPath(map, pid, path);
        }
        return path;
    }
    
    public void setServletRequest(HttpServletRequest hRequest) {
        this.request = hRequest;
    }
    
    public void setServletResponse(HttpServletResponse hResponse) {
        this.response = hResponse;
    }
    
    public final void validate() {
        session = request.getSession();
        super.validate();
    }
    
    public String getJson() {
        return json;
    }
    
    public void setJson(String json) {
        this.json = json;
    }
    
    public Page getPage() {
        return page;
    }
    
    public void setPage(Page page) {
        this.page = page;
    }
    
    public List getList() {
        return list;
    }
}