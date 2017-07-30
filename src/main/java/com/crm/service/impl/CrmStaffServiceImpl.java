package com.crm.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crm.dao.CrmDepartmentDao;
import com.crm.dao.CrmPostDao;
import com.crm.dao.CrmStaffDao;
import com.crm.dto.CrmStaffDto;
import com.crm.pojo.CrmPost;
import com.crm.pojo.CrmStaff;
import com.crm.service.CrmStaffService;

public class CrmStaffServiceImpl implements CrmStaffService {

	private CrmStaffDao crmStaffDao;
	private CrmPostDao crmPostDao;
	private CrmDepartmentDao crmDepartmentDao;
	
	
	public void setCrmStaffDao(CrmStaffDao crmStaffDao) {
		this.crmStaffDao = crmStaffDao;
	}

	public void setCrmPostDao(CrmPostDao crmPostDao) {
		this.crmPostDao = crmPostDao;
	}

	public void setCrmDepartmentDao(CrmDepartmentDao crmDepartmentDao) {
		this.crmDepartmentDao = crmDepartmentDao;
	}

	@Override
	public void addCrmStaff(Long postId,CrmStaff pojo) {

		CrmPost crmPost=crmPostDao.findById(postId);
		pojo.setCrmPost(crmPost);
		crmStaffDao.add(pojo);
	}

	@Override
	public List<CrmStaffDto> findAll() {
		List<CrmStaff> findAll = crmStaffDao.findAll();
		List<CrmStaffDto>list=new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (CrmStaff crmStaff : findAll) {
			CrmStaffDto csd=new CrmStaffDto();
			csd.setGender(crmStaff.getGender());
			csd.setPostName(crmStaff.getCrmPost().getPostName());
			csd.setDepName(crmStaff.getCrmPost().getCrmDepartment().getDepName());
			csd.setStaffName(crmStaff.getStaffName());
			Long time=crmStaff.getOnDutyDate();
			Date date=new Date(time);
			String onDutyDate=sdf.format(date);
			csd.setOnDutyDate(onDutyDate);
			list.add(csd);
			
		}
		return list;
	}

	@Override
	public CrmStaff findByName(String loginName) {
		CrmStaff findByName = crmStaffDao.findByName(loginName);
		if(findByName!=null){
			return findByName;
		}
		return null;
	}

	@Override
	public CrmStaff login(String loginName, String loginPwd) {
		CrmStaff crmStaff=crmStaffDao.findByNameAndPwd(loginName,loginPwd);
		if(crmStaff!=null){
			return crmStaff;
		}
		return null;
	}

}
