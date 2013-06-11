package com.framework.ssm.service.system;

import java.util.List;

import com.framework.ssm.pojo.User;
import com.framework.ssm.service.IBaseService;
import com.framework.ssm.service.IPageService;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:09:56 PM
 * <ul>
 * <li>comment:用户Service接口</li>
 * <ul>
 */
public interface UserService extends IBaseService<User, String>, IPageService<User> {
    
    /** 条件查找具体用户 */
    User findUser(User user);
    
    List<User> queryByRoleId(String roleId);
    
    void updatePassword(String userId, String newPwd, String oldPwd);
    
    User login(String username, String password);
    
    void setRoles(String userId, String[] roles);
}