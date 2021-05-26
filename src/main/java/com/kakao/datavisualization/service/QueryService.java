package com.kakao.datavisualization.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.datavisualization.dao.QueryDAO;
import com.kakao.datavisualization.model.DataResponseBody;
import com.kakao.datavisualization.model.MemberVO;
import com.kakao.datavisualization.model.QueryResultVO;
import com.kakao.datavisualization.model.QueryVO;
import com.kakao.datavisualization.model.QueryVO2;
import com.kakao.datavisualization.model.ResultVO;
import com.kakao.datavisualization.util.CommonUtil;

@Service
public class QueryService {
	
	@Autowired
	QueryDAO queryDAO;
	
	public DataResponseBody getQuery(MemberVO member) {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode("000");
		resultVO.setResultMessage("성공");
		
		List<QueryVO2> query = queryDAO.getQuery(member);
		
		responseVO.setQuery2(query);
		responseVO.setResult(resultVO);
		
		return responseVO;
	}

	public DataResponseBody getSequence() {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode("000");
		resultVO.setResultMessage("성공");
		
		QueryVO query = new QueryVO();
		query.setSequence( queryDAO.getSequence());
		
		List<QueryVO> querylist = new ArrayList<QueryVO>();
		querylist.add(query);
		
		responseVO.setQuery(querylist);
		responseVO.setResult(resultVO);
		
		return responseVO;
	}

	public DataResponseBody createQuery(QueryVO queryVO) {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		StringBuilder queryString = new StringBuilder();
		StringBuilder paramString = new StringBuilder();
		
		for(String query: queryVO.getQuery()) {
			queryString.append(CommonUtil.urlDecord(query) + "!@#");
		}
		
		for(String param: queryVO.getParam()) {
			paramString.append(CommonUtil.urlDecord(param) + "!@#");
		}
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("sequence", String.valueOf(queryVO.getSequence()));
		hashMap.put("userId", queryVO.getUserId());
		hashMap.put("query", queryString.toString());
		hashMap.put("param", paramString.toString());
		hashMap.put("title", queryVO.getTitle());

		int result = queryDAO.createQuery(hashMap);
		
		if (result >=0) {
			resultVO.setResultCode("000");
			resultVO.setResultMessage("성공");
		} else {
			resultVO.setResultCode("999");
			resultVO.setResultMessage("실패");
		}
		
		responseVO.setResult(resultVO);
		
		return responseVO;
	}

	public DataResponseBody selectQuery(String sequence) {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode("000");
		resultVO.setResultMessage("성공");
				
		responseVO.setQuery2(queryDAO.selectQuery(sequence));
		responseVO.setResult(resultVO);
		
		return responseVO;
	}

	public DataResponseBody updateQuery(QueryVO queryVO) {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		StringBuilder queryString = new StringBuilder();
		StringBuilder paramString = new StringBuilder();
		
		for(String query: queryVO.getQuery()) {
			queryString.append(CommonUtil.urlDecord(query) + "!@#");
		}
		
		for(String param: queryVO.getParam()) {
			paramString.append(CommonUtil.urlDecord(param) + "!@#");
		}
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("sequence", String.valueOf(queryVO.getSequence()));
		hashMap.put("userId", queryVO.getUserId());
		hashMap.put("query", queryString.toString());
		hashMap.put("param", paramString.toString());
		hashMap.put("title", queryVO.getTitle());

		int result = queryDAO.updateQuery(hashMap);
		
		if (result >=0) {
			resultVO.setResultCode("000");
			resultVO.setResultMessage("성공");
		} else {
			resultVO.setResultCode("999");
			resultVO.setResultMessage("실패");
		}
		
		responseVO.setResult(resultVO);
		
		return responseVO;
	}
	
	public QueryResultVO userCommand(QueryVO2 queryVO) {
		String preDataSql =queryVO.getQuery();
		String[] preDateParam = queryVO.getParam().split(",");
		
		for (int i = 0; i < preDateParam.length; i++) {
			preDataSql = preDataSql.replace("?", preDateParam[i]);
			
		}
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("sql", preDataSql);
		
		String dmlString = preDataSql.substring(0, 6);
		List<Map<String, Object>> result = null;
		
		if (dmlString.equals("SELECT")) {
			result = queryDAO.commandR(hm);
			System.out.println("SELECT 끝남");
			result = CommonUtil.paramNullCheck(result);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			result = new ArrayList<Map<String, Object>>();
			String res = queryDAO.commandCUD(hm, dmlString);
			map.put("result", res);
			result.add(map);
		}
		QueryResultVO queryResultVO = new QueryResultVO();
		queryResultVO.setQueryresult(result);
		
		return queryResultVO;
	}

//	public DataResponseBody userCommand(QueryVO2 queryVO) {
//		String preDataSql =queryVO.getQuery();
//		String[] preDateParam = queryVO.getParam().split(",");
//		
//		for (int i = 0; i < preDateParam.length; i++) {
//			preDataSql = preDataSql.replace("?", preDateParam[i]);
//			
//		}
//		HashMap<String, String> hm = new HashMap<String, String>();
//		hm.put("sql", preDataSql);
//		
//		String dmlString = preDataSql.substring(0, 6);
//		String result = queryDAO.doCURD(hm, dmlString);
//		
//		queryVO.setResult(result);
//		
//		ArrayList<QueryVO2> list = new ArrayList<QueryVO2>();
//		list.add(queryVO);
//		
//		ResultVO resultVO = new ResultVO();
//		resultVO.setResultCode("000");
//		resultVO.setResultMessage("성공");
//		
//		DataResponseBody responseVO = new DataResponseBody();
//		responseVO.setQuery2(list);
//		responseVO.setResult(resultVO);
//		
//		return responseVO;
//	}
}
