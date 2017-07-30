package com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.crm.dao.CrmDepartmentDao;
import com.crm.dto.CrmDepartmentDto;
import com.crm.dto.PageDto;
import com.crm.pojo.CrmDepartment;
import com.crm.service.CrmDepartmentService;

public class CrmDepartmentServiceImpl implements CrmDepartmentService{

	private CrmDepartmentDao crmDepartmentDao;

	public void setCrmDepartmentDao(CrmDepartmentDao crmDepartmentDao) {
		this.crmDepartmentDao = crmDepartmentDao;
	}

	@Override
	public void addCrmDepartment(CrmDepartment pojo) {
 
		crmDepartmentDao.add(pojo);
	}

	@Override
	public void updateCrmDepartment(Long depId, String depName) {

		CrmDepartment crmDepartment = crmDepartmentDao.findById(depId);
		crmDepartment.setDepName(depName);
		crmDepartmentDao.update(crmDepartment);
	}
	

	@Override
	public CrmDepartmentDto findById(Long id) {

		CrmDepartment dep = crmDepartmentDao.findById(id);
		CrmDepartmentDto depDto=new CrmDepartmentDto();
		depDto.setDepId(dep.getDepId());
		depDto.setDepName(dep.getDepName());
		return depDto;
	}

	@Override
	public List<CrmDepartmentDto> findAll() {

		List<CrmDepartmentDto> list=new ArrayList<>();
		List<CrmDepartment> allList=crmDepartmentDao.findAll();
		for (CrmDepartment dep : allList) {
			CrmDepartmentDto depDto=new CrmDepartmentDto();
			depDto.setDepId(dep.getDepId());
			depDto.setDepName(dep.getDepName());
			list.add(depDto);
		}
		return list;
	}

	@Override
	public List<CrmDepartmentDto> findByLike(String depName) {
		List<CrmDepartmentDto> list=new ArrayList<>();
		List<CrmDepartment> allList=crmDepartmentDao.findByLike(depName);
		for (CrmDepartment dep : allList) {
			CrmDepartmentDto depDto=new CrmDepartmentDto();
			depDto.setDepId(dep.getDepId());
			depDto.setDepName(dep.getDepName());
			list.add(depDto);
		}
		return list;
	}

	@Override
	public List<CrmDepartmentDto> findByPage(int page, String action, PageDto pageDto) {

		List<CrmDepartmentDto> list=new ArrayList<>();
		int start =pageDto.getStart();
		int size =pageDto.getSize();
		int maxNum=crmDepartmentDao.findMaxNum();
		
		int maxPage=(maxNum+size-1)/size;
		pageDto.setMaxPage(maxPage);
		
		if("pre".equals(action)){
			page=page-1;
			if(page<1){
				page=1;
			}
		}else if("next".equals(action)){
			page=page+1;
			if(page>maxPage){
				page=maxPage;
			}
		}
		pageDto.setPage(page);
		
		start=(page-1)*size;
		
		List<CrmDepartment> findPage=crmDepartmentDao.findByPage(start, size);
		for (CrmDepartment crmDepartment : findPage) {
			CrmDepartmentDto depDto=new CrmDepartmentDto();
			depDto.setDepId(crmDepartment.getDepId());
			depDto.setDepName(crmDepartment.getDepName());
			list.add(depDto);
		}
		return list;
	}

	@Override
	public CrmDepartment findByIdAndPost(Long depId) {
		CrmDepartment crmDepartment = crmDepartmentDao.findById(depId);
		return crmDepartment;
	}

	
}
