package com.crm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.dto.CrmDepartmentDto;
import com.crm.dto.CrmPostDto;
import com.crm.dto.CrmStaffDto;
import com.crm.pojo.CrmDepartment;
import com.crm.pojo.CrmPost;
import com.crm.pojo.CrmStaff;
import com.crm.service.CrmDepartmentService;
import com.crm.service.CrmPostService;
import com.crm.service.CrmStaffService;

@Controller
public class CrmStaffAction {

	@Autowired
	@Qualifier("crmStaffService")
	private CrmStaffService crmStaffService;
	
	public void setCrmStaffService(CrmStaffService crmStaffService) {
		this.crmStaffService = crmStaffService;
	}
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
	@RequestMapping("addPreStaff.do")
	public ModelAndView addPreStaff(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		List<CrmDepartmentDto> findAll = crmDepartmentService.findAll();
		mv.addObject("deptList",findAll);
		mv.setViewName("/pages/staff/addStaff.jsp");
		return mv;
	}
	@RequestMapping("ajaxByDepid.do")
	@ResponseBody
	public List<CrmPostDto> ajaxByDepid(HttpServletRequest request,HttpServletResponse response){
		List<CrmPostDto> list=new ArrayList<>();
		String depIdstr = request.getParameter("depId");
		if(depIdstr!=null){
			Long depId = Long.valueOf(depIdstr);
			list = crmPostService.findByDepid(depId);
		}
		return list;
	}
	@RequestMapping("addStaff.do")
	public ModelAndView addStaff(HttpServletRequest request,HttpServletResponse reponse) throws IllegalAccessException, InvocationTargetException, ParseException{
		ModelAndView mv=new ModelAndView();
		CrmStaff cs=new CrmStaff();
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		String staffName = request.getParameter("staffName");
		String gender = request.getParameter("gender");
		String depId = request.getParameter("depId");
		String postIdstr = request.getParameter("postId");
		long postId = Long.parseLong(postIdstr);
		String onDutyDatestr = request.getParameter("onDutyDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = sdf.parse(onDutyDatestr);
		Long onDutyDate = parse.getTime();
		cs.setGender(gender);
		cs.setLoginName(loginName);
		cs.setOnDutyDate(onDutyDate);
		cs.setLoginPwd(loginPwd);
		cs.setStaffName(staffName);
		crmStaffService.addCrmStaff(postId, cs);
		mv.setViewName("listStaff.do");
		return mv;
	}
	//查询所有的部门
	@RequestMapping("addPreStaff2")
	public ModelAndView addPreStaff2(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		List<CrmDepartmentDto> findAll = crmDepartmentService.findAll();
		mv.addObject("deptList",findAll);
		mv.setViewName("/pages/staff/addStaff.jsp");
		return mv;
	}
	@RequestMapping("addStaff2.do")
	public void addStaff2(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		String depId=request.getParameter("depId");
		CrmDepartment crmDepartment=crmDepartmentService.findByIdAndPost(Long.valueOf(depId));
		Set crmPosts = crmDepartment.getCrmPosts();
		StringBuffer sb=new StringBuffer("<option >--请选择部门--</option>");
		if(crmPosts!=null&&crmPosts.size()>0){
			for (Object object : crmPosts) {
				CrmPost crmPost=(CrmPost) object;
				Long id=crmPost.getPostId();
				sb.append("<option value='"+id+"'").append(crmPost.getPostName()).append("</option>");
			}
		}
		PrintWriter pw = response.getWriter();
		pw.println(sb.toString());
		pw.flush();
		pw.close();
	}
	
		@RequestMapping("listStaff.do")
	public ModelAndView listStaff(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		List<CrmStaffDto> findAll = crmStaffService.findAll();
		mv.addObject("staffList",findAll);
		mv.setViewName("/pages/staff/listStaff.jsp");
		return mv;
	}
		
		@RequestMapping("ajaxLoginName.do")
		@ResponseBody
		public int ajaxLoginName(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			
			String loginName = request.getParameter("loginName");
			CrmStaff findByName = crmStaffService.findByName(loginName);
			if(findByName!=null){
				return 1;
			}else{
				return 0;
			}
		}
		@RequestMapping("login.do")
		public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
			ModelAndView mv=new ModelAndView();
			String loginName = request.getParameter("loginName");
			String loginPwd = request.getParameter("loginPwd");
			CrmStaff crmStaff= crmStaffService.login(loginName,loginPwd);
			if(crmStaff!=null){
				request.getSession().setAttribute("user", crmStaff);
				mv.setViewName("/pages/frame.jsp");
			}else{
			mv.addObject("loginName",loginName);
			mv.addObject("error","密码错误请重新输入");
			mv.setViewName("/login.jsp");
			}
			return mv;
		}
		@RequestMapping("logout.do")
		public ModelAndView logout(HttpServletRequest request,HttpServletResponse response){
			ModelAndView mv=new ModelAndView("redirect:/login.jsp");
			request.getSession().invalidate();
			return mv;
		}
}
