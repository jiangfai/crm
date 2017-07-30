package com.crm.dao;

import java.io.Serializable;
import java.util.List;

import com.crm.pojo.CrmDepartment;

public interface CrmDepartmentDao extends BaseDao<CrmDepartment, Serializable>{
	
		
	public List<CrmDepartment> findByLike(String depName);
				
	public int findMaxNum();
}
