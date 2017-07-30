package com.crm.dao;


import java.io.Serializable;
import java.util.List;

import com.crm.pojo.CrmPost;

public interface CrmPostDao extends BaseDao<CrmPost, Serializable>{

	/*public void addCrmPost(CrmPost pojo);
	
	public List<CrmPost> findAll();*/
	
	public List<CrmPost> findByDeptid(Long depId);
}
