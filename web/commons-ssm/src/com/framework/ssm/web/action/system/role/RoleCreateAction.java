package com.framework.ssm.web.action.system.role;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.framework.ssm.pojo.Roles;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:01:14 PM
 * <ul>
 * <li>comment:角色创建</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class RoleCreateAction extends RoleBaseAction {
    
    public String checkRoleName() throws UnsupportedEncodingException {
        if (StringUtils.isNotEmpty(role.getName())) {
            role.setName(new String(role.getName().getBytes("ISO-8859-1"), "utf-8"));
            List<Roles> roleList = roleService.select(role);
            flag = roleList.isEmpty();
        }
        return SUCCESS;
    }
    
    protected String exec() {
        roleService.insert(role);
        return LIST;
    }
    
}