package com.framework.ssm.web.action.system.roleresource;

import java.util.List;

import javax.annotation.Resource;

import com.framework.ssm.pojo.Resources;
import com.framework.ssm.pojo.Roles;
import com.framework.ssm.service.system.ResourceService;
import com.framework.ssm.service.system.RoleService;
import com.framework.ssm.service.system.UserService;
import com.framework.ssm.web.action.StrutsAction;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:04:09 PM
 * <ul>
 * <li>comment:角色资源关联基础Action</li>
 * <ul>
 */
@SuppressWarnings("serial")
public abstract class RoleResourceBaseAction extends StrutsAction {
    
    protected List<Resources> list;
    
    protected List<Resources> rrlist;
    
    protected Roles role;
    
    @Resource
    protected ResourceService resourceService;
    
    @Resource
    protected RoleService roleService;
    
    @Resource
    protected UserService userService;
    
    public List<Resources> getList() {
        return list;
    }
    
    public List<Resources> getRrlist() {
        return rrlist;
    }
    
    public Roles getRole() {
        return role;
    }
    
    public void setRole(Roles role) {
        this.role = role;
    }
    
}