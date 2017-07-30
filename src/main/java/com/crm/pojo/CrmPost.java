package com.crm.pojo;
// Generated 2017-7-24 17:26:14 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * CrmPost generated by hbm2java
 */
public class CrmPost implements java.io.Serializable {

	private Long postId;
	private CrmDepartment crmDepartment;
	private String postName;
	private Set crmStaffs = new HashSet(0);

	public CrmPost() {
	}

	public CrmPost(CrmDepartment crmDepartment, String postName, Set crmStaffs) {
		this.crmDepartment = crmDepartment;
		this.postName = postName;
		this.crmStaffs = crmStaffs;
	}

	public Long getPostId() {
		return this.postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public CrmDepartment getCrmDepartment() {
		return this.crmDepartment;
	}

	public void setCrmDepartment(CrmDepartment crmDepartment) {
		this.crmDepartment = crmDepartment;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Set getCrmStaffs() {
		return this.crmStaffs;
	}

	public void setCrmStaffs(Set crmStaffs) {
		this.crmStaffs = crmStaffs;
	}

}
