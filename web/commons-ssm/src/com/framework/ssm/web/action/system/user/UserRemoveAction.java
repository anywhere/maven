package com.framework.ssm.web.action.system.user;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:07:02 PM
 * <ul>
 * <li>comment:用户删除</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class UserRemoveAction extends UserBaseAction {
    
    private String id;
    
    protected String exec() {
        String[] ids = id.split(",");
        for (String userID : ids) {
            userService.delete(userID);
        }
        return LIST;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
}