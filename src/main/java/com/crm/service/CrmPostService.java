package com.crm.service;

import java.util.List;

import com.crm.dto.CrmPostDto;
import com.crm.pojo.CrmPost;

public interface CrmPostService {

	public void addCrmPost(Long depId,String postName);
	
	public List<CrmPostDto> findALL();
	
	public List<CrmPostDto> findByDepid(Long depid);
}
