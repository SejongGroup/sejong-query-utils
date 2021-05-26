package com.kakao.datavisualization.model;

import java.util.List;

public class QueryVO {
	private Integer sequence;
	private String userId;
	private String title;
	private List<String> query;
	private List<String> param;
	


	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getQuery() {
		return query;
	}
	public void setQuery(List<String> query) {
		this.query = query;
	}
	public List<String> getParam() {
		return param;
	}
	public void setParam(List<String> param) {
		this.param = param;
	}
}
