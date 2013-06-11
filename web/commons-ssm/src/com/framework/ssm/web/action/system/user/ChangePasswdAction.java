package com.framework.ssm.web.action.system.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserCache;

import com.framework.ssm.security.AcegiUtils;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:08:20 PM
 * <ul>
 * <li>comment:用户密码修改</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class ChangePasswdAction extends UserBaseAction {
    
    private String confirmPassword;
    
    private String newPassword;
    
    private String oldPassword;
    
    private UserCache userCache;
    
    protected String exec() {
        // 对字段进行校验和过滤
        if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)
                || StringUtils.isEmpty(confirmPassword)) {
            addActionError(getText("请输入要修改的密码!"));
            return INPUT;
        }
        
        if (!oldPassword.equals(AcegiUtils.getCredentials())) {
            addActionError(getText("原密码错误!"));
            return INPUT;
        }
        user = AcegiUtils.getCurrentUser();
        if (newPassword.equals(confirmPassword)) {
            userService.updatePassword(user.getId(), newPassword, oldPassword);
            userCache.removeUserFromCache(user.getUsername());
            return SUCCESS;
        }
        return INPUT;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public String getNewPassword() {
        return newPassword;
    }
    
    public String getOldPassword() {
        return oldPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    
    public void setUserCache(UserCache userCache) {
        this.userCache = userCache;
    }
    
}