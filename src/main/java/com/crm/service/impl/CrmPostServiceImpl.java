package com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.crm.dao.CrmDepartmentDao;
import com.crm.dao.CrmPostDao;
import com.crm.dto.CrmPostDto;
import com.crm.pojo.CrmDepartment;
import com.crm.pojo.CrmPost;
import com.crm.service.CrmPostService;

public class CrmPostServiceImpl implements CrmPostService {

	//注入多个dao,需要查询department
	private CrmPostDao crmPostDao;
	private CrmDepartmentDao crmDepartmentDao;
	
	public void setCrmPostDao(CrmPostDao crmPostDao) {
		this.crmPostDao = crmPostDao;
	}

	public void setCrmDepartmentDao(CrmDepartmentDao crmDepartmentDao) {
		this.crmDepartmentDao = crmDepartmentDao;
	}

	@Override
	public void addCrmPost(Long depId, String postName) {
		CrmPost pojo=new CrmPost();
		pojo.setPostName(postName);
		CrmDepartment findById = crmDepartmentDao.findById(depId);
		pojo.setCrmDepartment(findById);
		crmPostDao.add(pojo);
	}

	@Override
	public List<CrmPostDto> findALL() {
		List<CrmPostDto> list=new ArrayList<>();
		List<CrmPost> findAll = crmPostDao.findAll();
		for (CrmPost crmPost : findAll) {
			CrmPostDto postDto=new CrmPostDto();
			postDto.setPostId(crmPost.getPostId());
			postDto.setDepName(crmPost.getCrmDepartment().getDepName());
			postDto.setPostName(crmPost.getPostName());
			list.add(postDto);
		}
		return list;
	}

	@Override
	public List<CrmPostDto> findByDepid(Long depid) {

		List<CrmPostDto>list=new ArrayList<>();
		List<CrmPost> findByDeptid = crmPostDao.findByDeptid(depid);
		for (CrmPost crmPost : findByDeptid) {
			CrmPostDto postDto=new CrmPostDto();
			postDto.setPostId(crmPost.getPostId());
			postDto.setDepName(crmPost.getCrmDepartment().getDepName());
			postDto.setPostName(crmPost.getPostName());
			list.add(postDto);
		}
		return list;
	}

}
