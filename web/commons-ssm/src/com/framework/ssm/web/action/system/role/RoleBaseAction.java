package com.framework.ssm.web.action.system.role;

import javax.annotation.Resource;

import com.framework.ssm.pojo.Roles;
import com.framework.ssm.service.system.RoleService;
import com.framework.ssm.web.action.StrutsAction;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:01:28 PM
 * <ul>
 * <li>comment:角色操作基础Action</li>
 * <ul>
 */
@SuppressWarnings("serial")
public abstract class RoleBaseAction extends StrutsAction {
    
    protected Roles role;
    
    protected boolean flag;
    
    @Resource
    protected RoleService roleService;
    
    public Roles getRole() {
        return role;
    }
    
    public void setRole(Roles role) {
        this.role = role;
    }
    
    public boolean isFlag() {
        return flag;
    }
}