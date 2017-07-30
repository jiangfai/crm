package com.crm.dao;

import java.io.Serializable;

import com.crm.pojo.CrmStaff;

public interface CrmStaffDao extends BaseDao<CrmStaff, Serializable>{
	
	public CrmStaff findByName(String loginName);
	
	public CrmStaff findByNameAndPwd(String loginName,String loginPwd);
}
