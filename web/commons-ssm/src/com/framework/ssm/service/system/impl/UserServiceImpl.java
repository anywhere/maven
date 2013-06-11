package com.framework.ssm.service.system.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.framework.ssm.dao.UserDao;
import com.framework.ssm.exception.BussinessException;
import com.framework.ssm.page.Page;
import com.framework.ssm.pojo.User;
import com.framework.ssm.service.system.UserService;
import com.framework.ssm.util.RandomGUID;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:12:01 PM
 * <ul>
 * <li>comment:用户Service实现类</li>
 * <ul>
 */
@SuppressWarnings("unchecked")
@Service
public class UserServiceImpl implements UserService {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Resource
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;
    
    @Resource
    private UserDao userDao;
    
    // 添加用户
    public void insert(User bean) throws BussinessException {
        List<User> list = userDao.queryByUsername(bean.getUsername());
        if (null != list && list.size() > 0) {
            // if (StringUtils.isNotEmpty(username)) {
            log.debug("{} already exits!", bean.getUsername());
            throw new BussinessException(CODE_ALREADY_EXIST, "label.username");
            // }
            // if (StringUtils.isNotEmpty(user.getMsisdn())) {
            // log.debug("{} already exits!", msisdn);
            // throw new BussinessException(CODE_UNIQUE, "label.msisdn");
            // }
        }
        
        // fill in internal field
        String password = passwordEncoder.encodePassword(bean.getPassword().trim(), bean.getUsername().trim());
        bean.setPassword(password);
        bean.setCreateDate(new Date());// 添加创建时间
        
        // DAO Operate
        bean.setId(RandomGUID.uuid());// 生成用户的ID
        userDao.insert(bean);
    }
    
    public void delete(String id) throws BussinessException {
        // 对字段进行校验和过滤
        // BeanValidator.notEmpty(id);
        
        // Business checksum
        User user = userDao.getById(id);
        if (null == user) {
            log.debug("user not exist");
            throw new BussinessException(CODE_NOT_EXIST, "label.user");
        }
        
        // DAO Operate
        userDao.delete(id);
    }
    
    public User get(String userId) {
        
        User user = userDao.getById(userId);
        if (null == user) {
            log.debug("user not exist");
            throw new BussinessException(CODE_NOT_EXIST, "label.user");
        }
        return user;
    }
    
    public User findUser(User user) {
        return userDao.get(user);
    }
    
    public List<User> select() {
        
        return userDao.select();
    }
    
    public List<User> select(User entity) {
        return userDao.select(entity);
    }
    
    public Page<User> queryPage(User user, Page page) {
        user.setPage(page);
        List<User> data = userDao.selectPage(user);
        int rowStart = (0 > page.getStart()) ? 0 : page.getStart();
        int pageSize = (0 > page.getPageSize()) ? 10 : page.getPageSize();
        page = new Page<User>(rowStart, userDao.count(user), pageSize, data);
        return page;
    }
    
    public List<User> queryByRoleId(String roleId) {
        return userDao.queryByRoleId(roleId);
    }
    
    // 更新用户
    public void update(User bean) throws BussinessException {
        // 对字段进行校验和过滤
        // BeanValidator.notNull(bean);
        // String[] properties = { "id", "displayname" };
        // BeanValidator.notEmpty(bean, properties);
        
        // Business checksum
        
        // fill in internal field
        bean.setPassword(null);
        
        // bean.setUsername(null); //会导致用户名无法改变
        
        // DAO Operate
        userDao.update(bean);
    }
    
    public void updatePassword(String userId, String newPwd, String oldPwd) {
        // 对参数进行校验和过滤
        // BeanValidator.notEmpty(userId);
        // BeanValidator.notEmpty(newPwd);
        // BeanValidator.notEmpty(oldPwd);
        
        // Business checksum
        User user = userDao.getById(userId);
        if (null == user) {
            log.debug("user does not exist");
            throw new BussinessException(CODE_NOT_EXIST, "label.user");
        }
        String encodePassword = passwordEncoder.encodePassword(oldPwd, user.getUsername().trim());
        if (!StringUtils.equalsIgnoreCase(user.getPassword(), encodePassword)) {
            log.debug("original password is error!");
            throw new BussinessException(CODE_ERROR, "原密码");
        }
        
        // fill in internal field
        String newPassword = passwordEncoder.encodePassword(newPwd, user.getUsername().trim());
        user.setPassword(newPassword);
        
        // DAO Operate
        userDao.update(user);
    }
    
    public User login(String username, String password) {
        String encodePassword = passwordEncoder.encodePassword(password, username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodePassword);
        return userDao.get(user);
    }
    
    public void setRoles(String userId, String[] roles) {
        User user = userDao.getById(userId);
        if (null == user) {
            log.debug("user does not exist");
            throw new BussinessException(CODE_NOT_EXIST, "label.user");
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        // userDao.deleteRole(userId);
        if (null != roles && roles.length > 0) {
            params.put("ids", roles);
            // userDao.insertRole(params);
        }
    }
    
}