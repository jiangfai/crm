package com.crm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.dao.CrmPostDao;
import com.crm.pojo.CrmPost;

public class CrmPostDaoImpl extends BaseDaoHibernateAdapter<CrmPost, Serializable> implements CrmPostDao {

	/*@Override
	public void addCrmPost(CrmPost pojo) {

		this.getHibernateTemplate().save(pojo);
	}

	@Override
	public List<CrmPost> findAll() {

		List<CrmPost> find = (List<CrmPost>) this.getHibernateTemplate().find("from CrmPost");
		return find;
	}*/

	@Override
	public List<CrmPost> findByDeptid(Long depId) {
		String queryString = "from CrmPost cp where cp.crmDepartment.depId=?";
		List<CrmPost> find = (List<CrmPost>)this.getHibernateTemplate().find(queryString, depId);
		return find;
	}

}
