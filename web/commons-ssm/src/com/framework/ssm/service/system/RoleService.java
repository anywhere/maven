package com.framework.ssm.service.system;

import java.util.List;

import com.framework.ssm.pojo.Roles;
import com.framework.ssm.service.IBaseService;
import com.framework.ssm.service.IPageService;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:10:44 PM
 * <ul>
 * <li>comment:角色Service接口</li>
 * <ul>
 */
public interface RoleService extends IBaseService<Roles, String>, IPageService<Roles> {
    
    List<Roles> queryByUserId(String userId);
    
    void setResources(String roleId, String[] resources);
    
    void deleteBatch(final List list);
}