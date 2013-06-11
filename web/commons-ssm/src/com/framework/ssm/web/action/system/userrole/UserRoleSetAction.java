package com.framework.ssm.web.action.system.userrole;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserCache;

import com.framework.ssm.exception.BussinessException;
import com.framework.ssm.pojo.User;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:04:45 PM
 * <ul>
 * <li>comment:用户角色关联设置</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class UserRoleSetAction extends UserRoleBaseAction {
    
    private String selectedRoles;
    
    @Resource
    private UserCache userCache;
    
    protected String exec() {
        if (StringUtils.isEmpty(user.getId())) {
            LOG.debug("user id is null");
            throw new BussinessException(CODE_IS_EMPTY);
        }
        String[] newRoles = selectedRoles.split(",");
        userService.setRoles(user.getId(), newRoles);
        
        // 更新缓存
        User users = userService.get(user.getId());
        userCache.removeUserFromCache(users.getUsername());
        return SUCCESS;
    }
    
    public String input() {
        list = roleService.select();
        urlist = roleService.queryByUserId(user.getId());
        if (null != urlist && !urlist.isEmpty()) {
            list.removeAll(urlist);
        }
        return INPUT;
    }
    
    public void setSelectedRoles(String selectedRoles) {
        this.selectedRoles = selectedRoles;
    }
    
}