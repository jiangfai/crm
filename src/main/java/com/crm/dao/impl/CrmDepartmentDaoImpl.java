package com.crm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.dao.CrmDepartmentDao;
import com.crm.pojo.CrmDepartment;

public class CrmDepartmentDaoImpl extends BaseDaoHibernateAdapter<CrmDepartment, Serializable> implements CrmDepartmentDao {


	@Override
	public List<CrmDepartment> findByLike(String depName) {

		String hql="from crm_departmrnt where depName like ?";
		List<CrmDepartment> list = (List<CrmDepartment>) this.getHibernateTemplate().find(hql, "%"+depName+"%");
		return null;
	}

	/*@Override
	public List<CrmDepartment> findAll() {

		List<CrmDepartment> list = (List<CrmDepartment>) this.getHibernateTemplate().find("from CrmDepartment");
		return list;
	}*/

	/*@Override
	public List<CrmDepartment> findByPage(int start, int size) {
		
		List<CrmDepartment> find=this.getHibernateTemplate().execute(new HibernateCallback<List<CrmDepartment>>() {
			
			public List<CrmDepartment> doInHibernate(Session session) throws HibernateException{
				Query query=session.createQuery("from CrmDepartment");
				query.setFirstResult(start);
				query.setMaxResults(size);
				return query.list();
			}
		});
		return find;
	}*/

	@Override
	public int findMaxNum() {

		String hql="select count(*) from CrmDepartment";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		return list.get(0).intValue();
	}

}
