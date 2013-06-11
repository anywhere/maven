package com.framework.ssm.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:21:19 PM
 * <ul>
 * <li>comment:分页对象. 包含当前页数据及分页信息如总记录数.</li>
 * <ul>
 * @param <T>
 */
public class Page<T> {
    
    public static final int DEFAULT_PAGE_SIZE = 10;
    
    /**
     * 获取任一页第一条数据在数据集的位置，每页条数使用默认值.
     * 
     * @see #getStartOfPage(int,int)
     */
    protected static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }
    
    /**
     * 获取任一页第一条数据在数据集的位置.
     * 
     * @param pageNo 从1开始的页号
     * @param pageSize 每页记录条数
     * @return 该页第一条数据
     */
    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }
    
    protected List<T> data; // 当前页中存放的记录
    
    protected int pageSize = DEFAULT_PAGE_SIZE; // 每页的记录数
    
    protected int start; // 当前页第一条数据在List中的位置,从0开始
    
    protected int totalRecord; // 总记录数
    
    /**
     * 构造方法，只构造空页.
     */
    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<T>(0));
    }
    
    /**
     * 默认构造方法.
     * 
     * @param start 本页数据在数据库中的起始位置
     * @param totalSize 数据库中总记录条数
     * @param pageSize 本页容量
     * @param data 本页包含的数据
     */
    public Page(int start, int totalSize, int pageSize, List<T> data) {
        this.start = start;
        this.totalRecord = totalSize;
        this.pageSize = pageSize;
        this.data = data;
    }
    
    /**
     * 取该页当前页码,页码从1开始.
     */
    public int getCurrentPage() {
        return start / pageSize + 1;
    }
    
    public List<T> getData() {
        return data;
    }
    
    /**
     * 取每页数据容量.
     */
    public int getPageSize() {
        return pageSize;
    }
    
    public int getStart() {
        return start;
    }
    
    /**
     * 取总页数.
     */
    public int getTotalPage() {
        if (totalRecord % pageSize == 0) {
            return totalRecord / pageSize;
        } else {
            return totalRecord / pageSize + 1;
        }
    }
    
    /**
     * 取总记录数.
     */
    public int getTotalRecord() {
        return totalRecord;
    }
    
    /**
     * 该页是否有下一页.
     */
    public boolean hasNextPage() {
        return getCurrentPage() < getTotalPage() - 1;
    }
    
    /**
     * 该页是否有上一页.
     */
    public boolean hasPreviousPage() {
        return getCurrentPage() > 1;
    }
    
    public void setData(List<T> data) {
        this.data = data;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public void setStart(int start) {
        this.start = start;
    }
}