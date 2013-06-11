package com.framework.ssm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.framework.ssm.page.Page;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:14:26 PM
 * <ul>
 * <li>comment:基础Dao接口</li>
 * <ul>
 * @param <T>
 */
public interface IGenericDao<T, PK extends Serializable> {
    
    /**
     * 插入一个实体（在数据库INSERT一条记录）
     * 
     * @param entity 实体对象
     */
    public abstract void insert(T entity);
    
    /**
     * 修改一个实体对象（UPDATE一条记录）
     * 
     * @param entity 实体对象
     * @return 修改的对象个数，正常情况=1
     */
    public abstract void update(T entity);
    
    /**
     * 修改符合条件的记录
     * <p>
     * 此方法特别适合于一次性把多条记录的某些字段值设置为新值（定值）的情况，比如修改符合条件的记录的状态字段
     * </p>
     * <p>
     * 此方法的另一个用途是把一条记录的个别字段的值修改为新值（定值），此时要把条件设置为该记录的主键
     * </p>
     * 
     * @param map 用于产生SQL的参数值，包括WHERE条件、目标字段和新值等
     * @return 修改的记录个数，用于判断修改是否成功
     */
    public abstract int update(Map map);
    
    /**
     * 按主键删除记录
     * 
     * @param primaryKey 主键对象
     * @return 删除的对象个数，正常情况=1
     */
    public abstract int delete(PK primaryKey);
    
    /**
     * 删除符合条件的记录
     * <p>
     * <strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong>
     * </p>
     * 
     * @param map 用于产生SQL的参数值，包括WHERE条件（其他参数内容不起作用）
     * @return
     */
    public abstract int delete(Map map);
    
    /**
     * 清空表，比delete具有更高的效率，而且是从数据库中物理删除（delete是逻辑删除，被删除的记录依然占有空间）
     * <p>
     * <strong>此方法一定要慎用！</strong>
     * </p>
     * 
     * @return
     */
    public abstract int truncate();
    
    /**
     * 查询整表总记录数
     * 
     * @return 整表总记录数
     */
    public abstract int count();
    
    /**
     * 查询符合条件的记录数
     * 
     * @param map 查询条件参数，包括WHERE条件（其他参数内容不起作用）。此参数设置为null，则相当于count()
     * @return
     */
    public abstract int count(T entity);
    
    /**
     * 按主键取记录
     * 
     * @param primaryKey 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    public abstract T getById(PK primaryKey);
    
    /**
     * 按对象记录
     * 
     * @param entity 对象
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    public abstract T get(T entity);
    
    /**
     * 取全部记录
     * 
     * @return 全部记录实体对象的List
     */
    public abstract List<T> select();
    
    /**
     * 按条件查询记录
     * 
     * @param map 查询条件参数，包括WHERE条件、分页条件、排序条件
     * @return 符合条件记录的实体对象的List
     */
    public abstract List<T> select(T entity);
    
    /**
     * 按条件查询记录
     * 
     * @param field 字段字符串
     * @return 符合条件记录的实体对象的List
     */
//    public abstract Map<String, T> selectMap(String field);
    
    /**
     * 按条件查询记录，并处理成分页结果
     * 
     * @param map 查询条件参数，包括WHERE条件、分页条件、排序条件
     * @return Map对象，包括（符合条件的）总记录数、页实体对象List等
     */
    public abstract List<T> selectPage(T entity);
    
    /**
     * 按条件查询记录，并把有外键关联的字段的关联对象也处理出来
     * <p>
     * 此方法是为了避免1+N而设置的
     * </p>
     * 
     * @param map 查询条件参数，包括WHERE条件、分页条件、排序条件<strong>（不包括外键关联表条件）</strong>
     * @return 符合条件记录的实体对象的List
     */
    public abstract List<T> selectFk(Map map);
    
    /**
     * 按条件查询记录，并把有外键关联的字段的关联对象也处理出来，并处理成分页结果
     * <p>
     * 此方法是为了避免1+N而设置的
     * </p>
     * 
     * @param map 查询条件参数，包括WHERE条件、分页条件、排序条件<strong>（不包括外键关联表条件）</strong>
     * @return Map对象，包括（符合条件的）总记录数、页实体对象List等
     */
    public abstract Page<T> selectFkPage(Map map);
    
    /**
     * 批量插入
     * 
     * @param list
     */
    public abstract void batchInsert(final List<T> list);
    
    /**
     * 批量修改
     * 
     * @param list
     */
    public abstract void batchUpdate(final List<T> list);
    
    /**
     * 批量删除
     * 
     * @param list
     */
    public abstract void batchDelete(final List<PK> list);
}