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
import com.crm.dto.CrmPostDto;
import com.crm.service.CrmDepartmentService;
import com.crm.service.CrmPostService;


@Controller
public class CrmPostAction {

	@Autowired
	@Qualifier("crmPostService")
	private CrmPostService crmPostService;

	public void setCrmPostService(CrmPostService crmPostService) {
		this.crmPostService = crmPostService;
	}
	@Autowired
	@Qualifier("crmDepartmentService")
	private CrmDepartmentService crmDepartmentService;

	public void setCrmDepartmentService(CrmDepartmentService crmDepartmentService) {
		this.crmDepartmentService = crmDepartmentService;
	}
	@RequestMapping("addPrePost.do")
	public ModelAndView addPrePost(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		List<CrmDepartmentDto> findAll = crmDepartmentService.findAll();
		mv.addObject("deptList",findAll);
		mv.setViewName("/pages/post/addOrEditPost.jsp");
		return mv;
	}
	
	@RequestMapping("addPost.do")
	public ModelAndView addPost(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		String depIdstr = request.getParameter("depId");
		long depId=0l;
		if(depIdstr!=null){
			depId=Long.valueOf(depIdstr);
		}
		String postName=request.getParameter("postName");
		crmPostService.addCrmPost(depId, postName);
		mv.setViewName("/listPost.do");
		return mv;
	}
	@RequestMapping("/listPost.do")
	public ModelAndView listPost(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		List<CrmPostDto> findALL = crmPostService.findALL();
		mv.addObject("listPost", findALL);
		mv.setViewName("/pages/post/listPost.jsp");
		return mv;
	}
}
