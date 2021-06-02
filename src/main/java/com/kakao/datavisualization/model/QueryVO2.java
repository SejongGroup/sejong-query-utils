package com.kakao.datavisualization.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class QueryVO2 {
	private Integer sequence;
	private String userId;
	private String title;
	private String query;
	private String param;
	private String databaseurl;
	
	public String getDatabaseurl() {
		return databaseurl;
	}
	public void setDatabaseurl(String databaseurl) {
		this.databaseurl = databaseurl;
	}
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
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
//	public String getResult() {
//		return result;
//	}
//	public void setResult(String result) {
//		this.result = result;
//	}
}
