package com.framework.ssm.service.system.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.framework.ssm.dao.RoleDao;
import com.framework.ssm.dao.UserDao;
import com.framework.ssm.exception.BussinessException;
import com.framework.ssm.page.Page;
import com.framework.ssm.pojo.Roles;
import com.framework.ssm.pojo.User;
import com.framework.ssm.service.system.RoleService;
import com.framework.ssm.util.RandomGUID;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:12:07 PM
 * <ul>
 * <li>comment:角色Service实现类</li>
 * <ul>
 */
@SuppressWarnings("unchecked")
@Service
public class RoleServiceImpl implements RoleService {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Resource
    private RoleDao roleDao;
    
    @Resource
    private UserDao userDao;
    
    public void insert(Roles role) throws BussinessException {
        // 对字段进行校验和过滤
        // BeanValidator.notNull(role);
        // String[] properties = { "name" };
        // BeanValidator.notEmpty(role, properties);
        
        // TODO Parameter checking
        
        Roles r = roleDao.get(role);
        if (null == r) {
            Date date = new Date();
            role.setCreateDate(date);
            role.setId(RandomGUID.uuid());
            roleDao.insert(role);
        } else {
            log.debug("{} already exist!", role.getName());
            throw new BussinessException(CODE_ALREADY_EXIST, role.getName());
        }
    }
    
    public void delete(String roleId) throws BussinessException {
        // 对字段进行校验和过滤
        // BeanValidator.notNull(roleId);
        
        // TODO Parameter checking
        
        Roles role = roleDao.getById(roleId);
        if (null == role) {
            log.debug("Role does not exist");
            throw new BussinessException(CODE_NOT_EXIST, "label.role");
        }
        // List<Resource> resources = role.getResources();
        // if (!resources.isEmpty()) {
        // LOGGER.debug("Roles associated with the resource can not be deleted");
        // throw new BussinessException(ROLE_RESOURCE_RELATION_EXIST);
        // }
        
        List<User> users = userDao.queryByRoleId(roleId);
        if (!users.isEmpty()) {
            log.debug("Roles associated with the resource can not be deleted");
            throw new BussinessException(CODE_ASSOCIATED, "用户角色");
        }
        // TODO
        roleDao.delete(roleId);
    }
    
    public Roles get(String roleId) {
        
        Roles role = roleDao.getById(roleId);
        if (null == role) {
            log.debug("Role does not exist");
            throw new BussinessException(CODE_NOT_EXIST, "label.role");
        }
        return roleDao.getById(roleId);
    }
    
    public Roles findByName(String rolename) {
        
        Roles role = new Roles();
        role.setName(rolename);
        return roleDao.get(role);
    }
    
    public List<Roles> select() {
        return roleDao.select();
    }
    
    public List<Roles> select(Roles entity) {
        return roleDao.select(entity);
    }
    
    public List<Roles> queryByUserId(String userId) {
        
        User user = userDao.getById(userId);
        if (null == user) {
            log.debug("user does not exist");
            throw new BussinessException(CODE_NOT_EXIST, "label.user");
        }
        return roleDao.queryByUserId(userId);
    }
    
    public Page<Roles> queryPage(Roles role, Page page) {
        role.setPage(page);
        List<Roles> data = roleDao.selectPage(role);
        int rowStart = (0 > page.getStart()) ? 0 : page.getStart();
        int pageSize = (0 > page.getPageSize()) ? 10 : page.getPageSize();
        page = new Page<Roles>(rowStart, roleDao.count(role), pageSize, data);
        return page;
    }
    
    public void update(Roles role) throws BussinessException {
        Roles r = roleDao.get(role);
        if (null == r) {
            roleDao.update(role);
        } else {
            log.debug("{} already exist!", role.getName());
            throw new BussinessException(CODE_ALREADY_EXIST, role.getName());
        }
    }
    
    public void setResources(String roleId, String[] resources) {
        Roles r = roleDao.getById(roleId);
        if (null == r) {
            log.debug("Role does not exist");
            throw new BussinessException(CODE_NOT_EXIST, "label.role");
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleId", roleId);
        roleDao.deleteResources(roleId);
        if (null != resources && resources.length > 0) {
            params.put("ids", resources);
            roleDao.setResources(params);
        }
        
    }
    
    public void deleteBatch(List list) {
        roleDao.batchDelete(list);
    }
    
}