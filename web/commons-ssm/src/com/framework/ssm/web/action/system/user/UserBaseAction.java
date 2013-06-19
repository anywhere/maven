package com.framework.ssm.web.action.system.user;

import javax.annotation.Resource;

import com.framework.ssm.pojo.User;
import com.framework.ssm.service.system.UserService;
import com.framework.ssm.web.action.file.FileAction;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:08:02 PM
 * <ul>
 * <li>comment:用户操作基础Action</li>
 * <ul>
 */
@SuppressWarnings("serial")
public abstract class UserBaseAction extends FileAction {
    
    protected User user;
    
    @Resource
    protected UserService userService;
    
    public UserService getUserService() {
        return userService;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}