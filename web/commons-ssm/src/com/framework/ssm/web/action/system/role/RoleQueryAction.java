package com.framework.ssm.web.action.system.role;

import com.framework.ssm.pojo.Roles;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 3:58:36 PM
 * <ul>
 * <li>comment: 角色查询类</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class RoleQueryAction extends RoleBaseAction {
    
    protected String exec() {
        if (role == null) {
            LOG.warn("role is null!");
            role = new Roles();
        }
        page = roleService.queryPage(role, page);
        return SUCCESS;
    }
    
}