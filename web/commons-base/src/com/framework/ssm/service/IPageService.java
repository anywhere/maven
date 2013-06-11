package com.framework.ssm.service;

import com.framework.ssm.page.Page;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:10:57 PM
 * <ul>
 * <li>comment:分页Service接口</li>
 * <ul>
 * @param <T>
 */
public interface IPageService<T> {
    
    /** 条件分页查询 */
    Page queryPage(T bean, Page page);
    
}