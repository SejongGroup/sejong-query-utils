package com.kakao.datavisualization.model;

import java.util.List;
import java.util.Map;

public class QueryResultVO {
	private List<Map<String, Object>> queryresult;

	public List<Map<String, Object>> getQueryresult() {
		return queryresult;
	}

	public void setQueryresult(List<Map<String, Object>> queryresult) {
		this.queryresult = queryresult;
	}

}
