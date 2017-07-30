package com.crm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.dao.BaseDao;




public abstract class BaseDaoHibernateAdapter <E, K extends Serializable> extends HibernateDaoSupport
		implements BaseDao<E, K> {
	protected Class<E> entityType;		// 传入的实体类型
	protected String entityName;		// 实体类型的名字
	
	public BaseDaoHibernateAdapter() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityType = (Class<E>) pt.getActualTypeArguments()[0];
		entityName = entityType.getSimpleName();
		System.out.println(entityName);
	}
	
	@Override
	public void add(E entity) {
		 this.getHibernateTemplate().save(entity);
	}


	@Override
	public void update(E entity) {
		this.getHibernateTemplate().update(entity);;
	}

	@Override
	public E findById(K id) {
		return this.getHibernateTemplate().get(entityType, id);
	}

	@Override
	public List<E> findAll() {
		
		return (List<E>) this.getHibernateTemplate().find("from "+entityName);
	}

	@Override
	public List<E> findByPage(int start, int size) {
		List<E> dataList = this.getSessionFactory().openSession()
				.createQuery("from " + entityName, entityType)
				.setFirstResult(start)
				.setMaxResults(size)
				.getResultList();
		
		return dataList;
	}

	
	
}
