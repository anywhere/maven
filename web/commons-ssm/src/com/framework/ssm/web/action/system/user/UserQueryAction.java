package com.framework.ssm.web.action.system.user;

import com.framework.ssm.pojo.User;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:07:14 PM
 * <ul>
 * <li>comment:用户查询</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class UserQueryAction extends UserBaseAction {
    
    protected String exec() {
        if (user == null) {
            LOG.warn("user is null!");
            user = new User();
        }
        page = userService.queryPage(user, page);
        return SUCCESS;
    }
    
}