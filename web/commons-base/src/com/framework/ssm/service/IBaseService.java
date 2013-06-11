package com.framework.ssm.service;

import java.io.Serializable;
import java.util.List;

import com.framework.ssm.exception.BussinessException;
import com.framework.ssm.util.ErrorCode;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:10:57 PM
 * <ul>
 * <li>comment:基础Service接口</li>
 * <ul>
 * @param <T>
 */
public interface IBaseService<T, PK extends Serializable> extends ErrorCode {
    
    /** 添加实体 */
    void insert(T bean) throws BussinessException;
    
    /** 删除实体 */
    void delete(PK id) throws BussinessException;
    
    /** 根据Id查找实体 */
    T get(PK id);
    
    /** 查询所有实体 */
    List<T> select();
    
    /** 根据条件查询所有实体 */
    List<T> select(T entity);
    
    /** 更新实体 */
    void update(T bean) throws BussinessException;
}