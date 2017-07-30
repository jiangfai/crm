package com.crm.service;

import java.util.List;

import com.crm.dto.CrmStaffDto;
import com.crm.pojo.CrmStaff;

public interface CrmStaffService {

	public void addCrmStaff(Long postId,CrmStaff pojo);
	
	public List<CrmStaffDto> findAll();
	
	public CrmStaff findByName(String loginName);
	 
	public CrmStaff login(String loginName,String loginPwd);
}
