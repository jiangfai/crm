package com.crm.pojo;
// Generated 2017-7-24 17:26:14 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * CrmStaff generated by hbm2java
 */
public class CrmStaff implements java.io.Serializable {

	private long staffId;
	private CrmPost crmPost;
	private String loginName;
	private String loginPwd;
	private String staffName;
	private String gender;
	private Long onDutyDate;
	private Set crmFollows = new HashSet(0);
	private Set crmRunoffs = new HashSet(0);
	private Set crmStations = new HashSet(0);
	private Set crmRefers = new HashSet(0);

	public CrmStaff() {
	}

	public CrmStaff(long staffId) {
		this.staffId = staffId;
	}

	public CrmStaff(long staffId, CrmPost crmPost, String loginName, String loginPwd, String staffName, String gender,
			Long onDutyDate, Set crmFollows, Set crmRunoffs, Set crmStations, Set crmRefers) {
		this.staffId = staffId;
		this.crmPost = crmPost;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.staffName = staffName;
		this.gender = gender;
		this.onDutyDate = onDutyDate;
		this.crmFollows = crmFollows;
		this.crmRunoffs = crmRunoffs;
		this.crmStations = crmStations;
		this.crmRefers = crmRefers;
	}

	public long getStaffId() {
		return this.staffId;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public CrmPost getCrmPost() {
		return this.crmPost;
	}

	public void setCrmPost(CrmPost crmPost) {
		this.crmPost = crmPost;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getOnDutyDate() {
		return this.onDutyDate;
	}

	public void setOnDutyDate(Long onDutyDate) {
		this.onDutyDate = onDutyDate;
	}

	public Set getCrmFollows() {
		return this.crmFollows;
	}

	public void setCrmFollows(Set crmFollows) {
		this.crmFollows = crmFollows;
	}

	public Set getCrmRunoffs() {
		return this.crmRunoffs;
	}

	public void setCrmRunoffs(Set crmRunoffs) {
		this.crmRunoffs = crmRunoffs;
	}

	public Set getCrmStations() {
		return this.crmStations;
	}

	public void setCrmStations(Set crmStations) {
		this.crmStations = crmStations;
	}

	public Set getCrmRefers() {
		return this.crmRefers;
	}

	public void setCrmRefers(Set crmRefers) {
		this.crmRefers = crmRefers;
	}

}
