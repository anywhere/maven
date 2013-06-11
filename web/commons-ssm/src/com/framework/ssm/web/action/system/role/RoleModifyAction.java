package com.framework.ssm.web.action.system.role;

import com.framework.ssm.exception.BussinessException;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:00:43 PM
 * <ul>
 * <li>comment:角色修改</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class RoleModifyAction extends RoleBaseAction {
    
    public String exec() {
        roleService.update(role);
        return LIST;
    }
    
    public String input() {
        if (null == role) {
            throw new BussinessException("0101");
        }
        role = roleService.get(role.getId());
        return INPUT;
    }
}