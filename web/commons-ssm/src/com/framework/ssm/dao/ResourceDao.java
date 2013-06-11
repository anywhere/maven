package com.framework.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.framework.ssm.pojo.Resources;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:14:23 PM
 * <ul>
 * <li>comment:资源Dao接口</li>
 * <ul>
 */
@Repository
public interface ResourceDao extends IGenericDao<Resources, String> {
    
    /** 条件查找具体资源 */
    public abstract Resources get(Resources resource);
    
    public abstract List<Resources> queryByRoleId(String roleId);
    
    public abstract List<Resources> queryResourceMenus(String id);
    
}