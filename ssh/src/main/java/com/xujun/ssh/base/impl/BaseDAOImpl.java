package com.xujun.ssh.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.xujun.ssh.base.BaseDAO;


public abstract class BaseDAOImpl<T,ID extends Serializable> implements BaseDAO<T,ID> {
	@Autowired
    private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}

    protected Class<T> clazz;

    @SuppressWarnings("unchecked")
	public BaseDAOImpl() {
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        clazz = (Class<T>)type.getActualTypeArguments()[0];
    }

    /**
     * 保存实体对象到数据库
     * @param entity
     * @throws Exception
     */
    @Override
    public void save(T entity) {
        getSession().persist(entity);
    }

    /**
     * 根据
     * @param jpql
     * @return
     * @throws Exception
     */
    @Override
    public T get(String jpql) {
        return this.get(jpql,null);
    }

    @SuppressWarnings("unchecked")
	@Override
    public T get(Class<T> c, ID id) {
        return (T) getSession().get(c,id);
    }
    @Override
    public T get(ID id) {
        return this.get(this.clazz,id);
    }

    @Override
    public T get(String jpql, Map<String, Object> params) {
        List<T> list = this.find(jpql,params);
        return (list==null || list.size() < 1) ? null : list.get(0);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void delete(String jpql) {
        this.delete(jpql,null);
    }

    @Override
    public void delete(String jpql, Map<String, Object> params) {
        this.buildQuery(jpql,params).executeUpdate();
    }

    @Override
    public void update(T entity) {
        getSession().merge(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
       getSession().saveOrUpdate(entity);
    }

    @Override
    public List<T> find() {
        StringBuilder query = new StringBuilder(" FROM " + this.clazz.getName() + " WHERE 1=1 ");
        return this.find(query.toString());
    }

    @Override
    public List<T> find(String jpql) {
        return this.find(jpql,null);
    }

    @Override
    public List<T> find(int page, int rows) {
        StringBuilder query = new StringBuilder(" FROM " + this.clazz.getName() + " WHERE 1=1 ");
        return this.find(query.toString(),page,rows);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<T> find(String jpql, Map<String, Object> params) {
        return (List<T>)this.buildQuery(jpql,params).list();
    }

    @Override
    public List<T> find(String jpql, int page, int rows) {
        return this.find(jpql,null,page,rows);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<T> find(String jpql, Map<String, Object> params, int page, int rows) {
        return (List<T>)this.buildQuery(jpql,params).setFirstResult((page-1)*rows).setMaxResults(rows).list();
    }

    @Override
    public Long getCount() {
        StringBuilder count = new StringBuilder("SELECT COUNT(1) FROM " + this.clazz.getName() +" WHERE 1=1 ");
        return this.getCount(count.toString());
    }

    @Override
    public Long getCount(String jpql) {
        return this.getCount(jpql,null);
    }

    @Override
    public Long getCount(String jpql, Map<String, Object> params) {
        return (Long)this.buildQuery(jpql,params).uniqueResult();
    }

    @Override
    public int executeHQL(String jpql) {
        return this.buildQuery(jpql).executeUpdate();
    }

    @Override
    public int executeSQL(String sql) {
        return this.getSession().createSQLQuery(sql).executeUpdate();
    }

    @Override
    public Query buildQuery(String jpql) {
        return this.buildQuery(jpql, null);
    }

    @Override
    public Query buildQuery(String jpql, Map<String, Object> params) {
        Query query = getSession().createQuery(jpql);
        if(params != null && !params.isEmpty()){
            for(String key:params.keySet()){
                query.setParameter(key,params.get(key));
            }
        }
        return query;
    }

    
}
