package com.framework.ssm.service;

import java.util.List;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:10:57 PM
 * <ul>
 * <li>comment:首页Service接口</li>
 * <ul>
 * @param <T>
 */
public interface IIndexService<T> {
    
    /** 获取APChart图相关数据 */
    List ACChartdata(String name, String perfor);
    
    /** 创建AC厂家Chart图相关数据 */
    List ACPiedata(String city);
    
    /** 获取ACChart图相关数据 */
    List APChartdata(String name, String perfor);
    
    /** 创建AP厂家Chart图相关数据 */
    List APPiedata(String city);
    
    /** 获取HPChart图相关数据 */
    List HPChartdata(String name, String perfor);
}
