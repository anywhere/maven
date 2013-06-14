package com.framework.ssm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.framework.ssm.pojo.Roles;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:14:19 PM
 * <ul>
 * <li>comment:角色Dao接口</li>
 * <ul>
 */
@Repository
public interface RoleDao extends IGenericDao<Roles, String> {
    
    /** 条件查询所有角色 */
    public abstract List<Roles> queryByUserId(String userId);
    
    /** 条件查询所有角色 */
    public abstract List<Roles> queryByResourceId(String resourceId);
    
    public abstract void deleteResources(String roleId);
    
    public abstract void setResources(Map<String, Object> params);
    
}