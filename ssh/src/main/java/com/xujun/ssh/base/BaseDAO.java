package com.xujun.ssh.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;


/**
 * 
 */
public interface BaseDAO<T,ID extends Serializable> {

    /**
     * 公共保存方法
     */
    public void save(T entity);
    /**
     * 获取对象方法
     */
    public T get(String jpql);
    /**
     * 根据id获取对象方法
     * @param c
     * @param id
     * @return
     * @throws Exception
     */
    public T get(Class<T> c, ID id);
    /**
     * 根据id获取对象方法
     * @param id
     * @return
     * @throws Exception
     */
    public T get(ID id);
    /**
     * 获取对象方法
     * @param jpql
     * @param params
     * @return
     * @throws Exception
     */
    public T get(String jpql, Map<String, Object> params);
    /**
     * 删除方法
     * @throws Exception
     */
    public void delete(T entity);
    /**
     * 根据ID删除方法
     * @throws Exception
     */
    public void delete(String jpql)throws Exception;
    public void delete(String jpql, Map<String, Object> params)throws Exception;
    /**
     * 修改方法
     * @param entity
     * @throws Exception
     */
    public void update(T entity);
    /**
     * 添加或更新方法
     * @param entity
     * @throws Exception
     */
    public void saveOrUpdate(T entity);
    /**
     * 查询结果集方法
     * @return
     * @throws Exception
     */
    public List<T> find();
    /**
     * 查询结果集方法
     * @param jpql
     * @return
     * @throws Exception
     */
    public List<T> find(String jpql);
    /**
     * 查询结果集方法
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    public List<T> find(int page, int rows);
    /**
     * 重构的查询结果集方法
     * @param jpql
     * @param params
     * @return
     * @throws Exception
     */
    public List<T> find(String jpql, Map<String, Object> params);
    /**
     * 重构的分页查询结果集方法
     * @param jpql
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    public List<T> find(String jpql, int page, int rows);
    /**
     * 重构的分页查询结果集方法带查询参数
     * @param jpql
     * @param params
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    public List<T> find(String jpql, Map<String, Object> params, int page, int rows);
    /**
     * 查询总记录数
     * @return
     * @throws Exception
     */
    public Long getCount();
    /**
     * 查询总记录数
     * @param jpql
     * @return
     * @throws Exception
     */
    public Long getCount(String jpql);
    /**
     * 查询总记录数 携带查询参数
     * @param jpql
     * @return
     * @throws Exception
     */
    public Long getCount(String jpql, Map<String, Object> params);
    /**
     * 手工执行jpql语句方法
     * @param jpql
     * @return
     * @throws Exception
     */
    public int executeHQL(String jpql);
    /**
     * 手工执行sql语句方法
     * @param sql
     * @return
     * @throws Exception
     */
    public int executeSQL(String sql);

    public Query buildQuery(String jpql);

    public Query buildQuery(String jpql, Map<String, Object> params);
}
