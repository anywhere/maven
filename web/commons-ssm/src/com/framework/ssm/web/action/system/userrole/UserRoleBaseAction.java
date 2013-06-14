package com.framework.ssm.web.action.system.userrole;

import java.util.List;

import javax.annotation.Resource;

import com.framework.ssm.pojo.Roles;
import com.framework.ssm.pojo.User;
import com.framework.ssm.service.system.RoleService;
import com.framework.ssm.service.system.UserService;
import com.framework.ssm.web.action.StrutsAction;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:04:30 PM
 * <ul>
 * <li>comment:用户角色关联基础Action</li>
 * <ul>
 */
@SuppressWarnings("serial")
public abstract class UserRoleBaseAction extends StrutsAction {
    
    protected List<Roles> urlist;
    
    protected User user;
    
    @Resource
    protected UserService userService;
    
    @Resource
    protected RoleService roleService;
    
    public List<Roles> getUrlist() {
        return urlist;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
}