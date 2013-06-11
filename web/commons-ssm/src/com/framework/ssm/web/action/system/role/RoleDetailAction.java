package com.framework.ssm.web.action.system.role;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:00:55 PM
 * <ul>
 * <li>comment:角色详细信息</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class RoleDetailAction extends RoleBaseAction {
    
    protected String exec() {
        role = roleService.get(role.getId());
        return SUCCESS;
    }
}