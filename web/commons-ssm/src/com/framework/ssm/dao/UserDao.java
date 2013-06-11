package com.framework.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.framework.ssm.pojo.User;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:14:14 PM
 * <ul>
 * <li>comment:用户Dao接口</li>
 * <ul>
 */
@Repository
public interface UserDao extends IGenericDao<User, String> {
    
    /** 条件查询所有用户 */
    public abstract List<User> queryByRoleId(String roleId);
    
    /** 条件查询所有用户 */
    public abstract List<User> queryByUsername(String username);
    
}