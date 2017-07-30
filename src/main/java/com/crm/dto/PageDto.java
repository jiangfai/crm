package com.crm.dto;

public class PageDto {

	private int start=0;
	private int size=3;
	private int maxPage;
	private int page;
	private String actionPre="pre";
	private String actionNext="next";
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getActionPre() {
		return actionPre;
	}
	public void setActionPre(String actionPre) {
		this.actionPre = actionPre;
	}
	public String getActionNext() {
		return actionNext;
	}
	public void setActionNext(String actionNext) {
		this.actionNext = actionNext;
	}
	
}
