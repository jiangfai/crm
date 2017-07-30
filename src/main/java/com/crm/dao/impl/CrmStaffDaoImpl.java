package com.crm.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.crm.dao.CrmStaffDao;
import com.crm.pojo.CrmStaff;

public class CrmStaffDaoImpl extends BaseDaoHibernateAdapter<CrmStaff, Serializable> implements CrmStaffDao {

	@Override
	public CrmStaff findByName(String loginName) {

		List<CrmStaff> find = (List<CrmStaff>) this.getHibernateTemplate().find("from CrmStaff as cs where cs.loginName=?", loginName);
		if(find.size()>0){
			return  find.get(0);
		}
		return null;
	}

	@Override
	public CrmStaff findByNameAndPwd(String loginName, String loginPwd) {
		List<CrmStaff> find = (List<CrmStaff>) this.getHibernateTemplate().find("from CrmStaff as cs where cs.loginName=? and cs.loginPwd=?", loginName,loginPwd);
		if(find.size()>0){
			return  find.get(0);
		}
		return null;
	}

}
