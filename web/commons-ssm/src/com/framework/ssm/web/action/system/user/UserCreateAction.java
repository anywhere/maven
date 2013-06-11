package com.framework.ssm.web.action.system.user;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:07:40 PM
 * <ul>
 * <li>comment:用户创建</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class UserCreateAction extends UserBaseAction {
    
    private boolean flag;
    
    public String checkName() throws UnsupportedEncodingException {
        if (StringUtils.isNotEmpty(user.getUsername())) {
            user.setUsername(new String(user.getUsername().getBytes("ISO-8859-1"), "utf-8"));
            user = this.userService.findUser(user);
            flag = null == user;
        }
        return SUCCESS;
    }
    
    protected String exec() {
        this.userService.insert(user);
        return LIST;
    }
    
    public boolean isFlag() {
        return flag;
    }
    
}