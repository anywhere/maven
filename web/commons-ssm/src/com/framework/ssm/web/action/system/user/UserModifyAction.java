package com.framework.ssm.web.action.system.user;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:07:23 PM
 * <ul>
 * <li>comment:用户修改</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class UserModifyAction extends UserBaseAction {
    
    public String exec() {
        userService.update(user);
        return LIST;
    }
    
    public String input() {
        user = userService.get(user.getId());
        return INPUT;
    }
    
}