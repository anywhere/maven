package com.framework.ssm.service.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.framework.ssm.dao.ResourceDao;
import com.framework.ssm.dao.RoleDao;
import com.framework.ssm.exception.BussinessException;
import com.framework.ssm.pojo.Resources;
import com.framework.ssm.pojo.Roles;
import com.framework.ssm.service.system.ResourceService;
import com.framework.ssm.util.RandomGUID;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:12:14 PM
 * <ul>
 * <li>comment:资源Service实现类</li>
 * <ul>
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    
    private boolean judge = true;
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Resource
    private ResourceDao resourceDao;
    
    @Resource
    private RoleDao roleDao;
    
    private List<Resources> standby = new ArrayList<Resources>();
    
    public void insert(Resources resource) throws BussinessException {
        // 对字段进行校验和过滤
        // BeanValidator.notNull(resource);
        // String[] properties = { "name", "pid" };
        // BeanValidator.notEmpty(resource, properties);
        
        // 判断一下pid在数据库是否存在
        Resources res = resourceDao.getById(resource.getPid());
        if (null == res) {
            throw new BussinessException(CODE_REQUIRED, "pid");
        }
        
        Resources r = resourceDao.get(resource);
        if (null == r) {
            resource.setRootId("0");
            resource.setCurrentOrder(1);
            resource.setCurrentLevel(1);
            resource.setCreateDate(new Date());
            resource.setId(RandomGUID.uuid());
            resourceDao.insert(resource);
        } else {
            log.debug("{} already exits!", resource.getName());
            throw new BussinessException(CODE_ALREADY_EXIST, resource.getName());
        }
    }
    
    public void delete(String resourceId) throws BussinessException {
        // 对字段进行校验和过滤
        // BeanValidator.notNull(resourceId);
        
        // 判断一下id在数据库是否存在
        Resources res1 = resourceDao.getById(resourceId);
        if (null == res1) {
            return;
        }
        // 判断是不是不能被删除的资源
        Resources resource = resourceDao.getById(resourceId);
        if (resource.getFixed() == 1) {
            throw new BussinessException(CODE_DELETE_FORBID, "系统管理下的资源");
        }
        standby.clear();
        judge = true;
        standby.add(resource);
        // 删除条件判断
        List<Roles> resource_list = roleDao.queryByResourceId(resourceId);
        // 包含“资源-角色”关系不能被删除
        if (resource_list.size() > 0) {
            // 清空standby，不删除任何元素
            judge = false;
            // 通知界面删除操作失败。。。。
            log.debug("{} associated with roles can not be deletedt", resource.getName());
            throw new BussinessException(CODE_ASSOCIATED, resource.getName());
            /*for (RoleResource roleResource : list) {
                roleResourceDao.deleteByResourceID(roleResource.getResource().getId());
            }*/
            
        }
        this.delete_judgement(resourceId);
        /* List<RoleResource> list = roleResourceDao.findByResourceId(resourceId);
         if (list.size() > 0) {
             for (RoleResource roleResource : list) {
                 roleResourceDao.deleteByResourceID(roleResource.getResource().getId());
             }
         }*/
        
        if (judge) {
            for (Resources res : standby) {
                resourceDao.delete(res.getId());
                
            }
        }
        
    }
    
    private void delete_judgement(String resourceId) {
        // 对字段进行校验和过滤
        // BeanValidator.notNull(resourceId);
        
        Resources resource = resourceDao.getById(resourceId);
        
        List<Resources> all = resourceDao.select();
        Iterator<Resources> it = all.iterator();
        while (it.hasNext()) {
            Resources intermediate = (Resources) it.next();
            // 如果父节点与删除的元素的id相同，则该元素为其子节点，也应被删除
            if (intermediate.getPid().equals(resource.getId())) {
                List<Roles> list = roleDao.queryByResourceId(intermediate.getId());
                // 包含“资源-角色”关系不能被删除
                if (list.size() > 0) {
                    // 清空standby，不删除任何元素
                    judge = false;
                    // 通知界面删除操作失败。。。。
                    log.debug("{} associated with roles can not be deletedt", intermediate.getName());
                    throw new BussinessException(CODE_ASSOCIATED, resource.getName());
                    /*for (RoleResource roleResource : list) {
                        roleResourceDao.deleteByResourceID(roleResource.getResource().getId());
                    }*/
                    
                } else {
                    standby.add(intermediate);
                    this.delete_judgement(intermediate.getId());
                }
            }
        }
    }
    
    public Resources get(String resourceId) throws BussinessException {
        
        return resourceDao.getById(resourceId);
    }
    
    public Resources findResource(Resources resource) {
        return resourceDao.get(resource);
    }
    
    public List<Resources> select() {
        
        return resourceDao.select();
    }
    
    public List<Resources> select(Resources entity) {
        
        return resourceDao.select(entity);
    }
    
    public Map<String, Resources> queryAllMap() {
        Map<String, Resources> map = new HashMap<String, Resources>();
        List<Resources> list = resourceDao.select();
        for (Resources resource : list) {
            map.put(resource.getId(), resource);
        }
        return map;
    }
    
    public List<Resources> queryByRoleId(String roleId) {
        
        return resourceDao.queryByRoleId(roleId);
    }
    
    public List<Resources> queryResourceMenus(String id) {
        return resourceDao.queryResourceMenus(id);
    }
    
    public void update(List<Resources> list) throws BussinessException {
        // BeanValidator.notEmpty(list);
        for (Resources resource : list) {
            // 对字段进行校验和过滤
            // BeanValidator.notNull(resource);
            // String[] properties = { "id" };
            // BeanValidator.notEmpty(resource, properties);
            
            // 判断一下id在数据库是否存在
            Resources res1 = resourceDao.getById(resource.getId());
            if (null == res1) {
                throw new BussinessException(CODE_NOT_EXIST, "该资源");
            }
            
            Resources res = resourceDao.getById(resource.getId());
            if (null != res) {
                res.setName(null);
                res.setIsMenu(resource.getIsMenu());
                res.setIsParent(resource.getIsParent());
                res.setVisiable(resource.getVisiable());
                res.setIconSkin(resource.getIconSkin());
                res.setCurrentOrder(resource.getCurrentOrder());
                resourceDao.update(res);
            } else {
                log.debug("{} not exist", resource.getId());
            }
        }
    }
    
    public void update(Resources resource) throws BussinessException {
        // 对字段进行校验和过滤
        // BeanValidator.notNull(resource);
        // String[] properties = { "id", "name" };
        // BeanValidator.notEmpty(resource, properties);
        
        Resources res = resourceDao.getById(resource.getId());
        Resources r = resourceDao.get(resource);
        if (null == r) {
            res.setName(resource.getName());
            res.setIsMenu(resource.getIsMenu());
            res.setIsParent(resource.getIsParent());
            res.setVisiable(resource.getVisiable());
            res.setUrl(resource.getUrl());
            res.setIconSkin(resource.getIconSkin());
            res.setCurrentOrder(resource.getCurrentOrder());
            resourceDao.update(res);
        } else {
            log.debug("{} already exits!", resource.getName());
            throw new BussinessException(CODE_ALREADY_EXIST, resource.getName());
        }
    }
}