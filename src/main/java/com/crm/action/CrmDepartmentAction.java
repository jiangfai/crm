package com.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crm.dto.CrmDepartmentDto;
import com.crm.dto.PageDto;
import com.crm.pojo.CrmDepartment;
import com.crm.service.CrmDepartmentService;


@Controller
public class CrmDepartmentAction {

	@Autowired
	@Qualifier("crmDepartmentService")
	private CrmDepartmentService crmDepartmentService;

	public void setCrmDepartmentService(CrmDepartmentService crmDepartmentService) {
		this.crmDepartmentService = crmDepartmentService;
	}
	@RequestMapping("addDepart.do")
	public ModelAndView addDepart(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		String depName = request.getParameter("depName");
		CrmDepartment pojo = new CrmDepartment();
		pojo.setDepName(depName);
		crmDepartmentService.addCrmDepartment(pojo);
		mv.setViewName("/listDepart.do");
		return mv;
	}
	
	@RequestMapping("listDepart.do")
	public ModelAndView listDepart(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		String pagestr=request.getParameter("page");
		//没有传page的时候默认为1
		int page=1;
		if(pagestr!=null){
			page=Integer.parseInt(pagestr);
		}
		String action=request.getParameter("action");
		PageDto pageDto=new PageDto();
		List<CrmDepartmentDto> allList = crmDepartmentService.findByPage(page, action, pageDto);
		mv.addObject("listDepart", allList);
		mv.addObject("page",pageDto.getPage());
		mv.addObject("maxPage",pageDto.getMaxPage());
		mv.setViewName("/pages/department/listDepartment.jsp");
		return mv;
	}
	
	@RequestMapping("preUpdateDepart.do")
	public ModelAndView preUpdateDepart(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		String parameter = request.getParameter("depId");
		CrmDepartmentDto findById = crmDepartmentService.findById(Long.valueOf(parameter));
		mv.addObject("dept", findById);
		mv.setViewName("/pages/department/editDepartment.jsp");
		return mv;
	}
	
	@RequestMapping("/updateDepart.do")
	public ModelAndView updateDepart(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//得到隐藏域的主键
		String depIdstr = request.getParameter("depId");
		Long depId  = Long.valueOf(depIdstr);
		String depName = request.getParameter("depName");
		//根据主键修改某个字段
		crmDepartmentService.updateCrmDepartment(depId, depName);
		mv.setViewName("/listDepart.do");
		return mv;
	}
}
