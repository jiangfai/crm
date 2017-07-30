package com.crm.service;

import java.util.List;

import com.crm.dto.CrmDepartmentDto;
import com.crm.dto.PageDto;
import com.crm.pojo.CrmDepartment;

public interface CrmDepartmentService {

	public void addCrmDepartment(CrmDepartment pojo);
	
	public void updateCrmDepartment(Long depId,String depName);
	
	public CrmDepartmentDto findById(Long id);
	
	public List<CrmDepartmentDto> findAll();
	
	public List<CrmDepartmentDto> findByLike(String depName);
	
	public List<CrmDepartmentDto> findByPage(int page,String action,PageDto pageDto);

	public CrmDepartment findByIdAndPost(Long depId);
}
