package com.framework.ssm.web.action.system.user;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:07:31 PM
 * <ul>
 * <li>comment:用户详细信息</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class UserDetailAction extends UserBaseAction {
    
    protected String exec() {
        user = userService.get(user.getId());
        return SUCCESS;
    }
}