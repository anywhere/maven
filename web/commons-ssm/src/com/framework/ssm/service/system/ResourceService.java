package com.framework.ssm.service.system;

import java.util.List;
import java.util.Map;

import com.framework.ssm.exception.BussinessException;
import com.framework.ssm.pojo.Resources;
import com.framework.ssm.service.IBaseService;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:10:54 PM
 * <ul>
 * <li>comment:资源Service接口</li>
 * <ul>
 */
public interface ResourceService extends IBaseService<Resources, String> {
    
    /** 条件查找具体资源 */
    Resources findResource(Resources resource);
    
    Map<String, Resources> queryAllMap();
    
    List<Resources> queryByRoleId(String roleId);
    
    List<Resources> queryResourceMenus(String id);
    
    /** 批量更新 */
    void update(List<Resources> list) throws BussinessException;
}