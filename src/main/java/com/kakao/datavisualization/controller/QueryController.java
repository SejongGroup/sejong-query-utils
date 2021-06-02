package com.kakao.datavisualization.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kakao.datavisualization.interceptor.Auth;
import com.kakao.datavisualization.model.DataResponseBody;
import com.kakao.datavisualization.model.MemberVO;
import com.kakao.datavisualization.model.QueryResultVO;
import com.kakao.datavisualization.model.QueryVO;
import com.kakao.datavisualization.model.QueryVO2;
import com.kakao.datavisualization.model.QueryVO2;
import com.kakao.datavisualization.service.QueryService;
import com.kakao.datavisualization.service.SqlDriverService;
import com.kakao.datavisualization.util.CommonUtil;

@Controller
@RequestMapping("/query")
public class QueryController {
	@Autowired
	QueryService queryService;
	
	@Autowired
	SqlDriverService sqlDriverService;
	
	@Auth
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView queryJSP(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="responseType", required=false) String responseType) throws IOException {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		DataResponseBody responseVO = queryService.getQuery(member);
		responseVO.setMember(member);
		Gson gson = new Gson();
		String json = gson.toJson(responseVO);
		if (responseType == null || !responseType.equals("html")) {
			response.getWriter().write(json);
			return null;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", responseVO);
		mav.setViewName("query/main");
		return mav;	
	}
	
	@Auth
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createQueryJSP(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="responseType", required=false) String responseType) throws IOException {
				
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		DataResponseBody responseVO = queryService.getSequence();
		responseVO.setMember(member);
		
		Gson gson = new Gson();
		String json = gson.toJson(responseVO);
		
		mav.addObject("data", responseVO);
		mav.setViewName("query/create");
		
		return mav;	
	}
	
	@Auth
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public ModelAndView viewQueryJSP(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="sequence") String sequence, @RequestParam(value="responseType", required=false) String responseType) throws IOException {

		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		DataResponseBody responseVO = queryService.selectQuery(sequence);
		responseVO.setMember(member);
		
		responseVO.setSqldriver(sqlDriverService.selectDriver());
		
		mav.addObject("data", responseVO);
		mav.setViewName("query/create");
		return mav;	
	}
	
	@Auth
	@RequestMapping(value="/createaction", method=RequestMethod.POST)
	public ModelAndView createQuery(HttpServletRequest request, HttpServletResponse response
			, @RequestParam(value="sequence") String sequence
			, @RequestParam(value="userId") String userId
			, @RequestParam(value="responseType", required=false) String responseType
			, @RequestParam(value="title", required=false) String title
			, @RequestParam(value="query[]", required=false) List<String> query
			, @RequestParam(value="param[]", required=false) List<String> param) throws IOException {

		QueryVO queryVO = new QueryVO();
		
		queryVO.setParam(param);
		queryVO.setQuery(query);
		queryVO.setUserId(userId);
		queryVO.setTitle(title);

		
		String queryUser = null;
		 
		try {
			queryUser = queryService.selectQuery(sequence).getQuery2().get(0).getUserId();
		} catch (Exception e) {
			/* error 처리 안함. insert 될 것들 */
		}
		
		
		DataResponseBody responseVO = null;
		if (queryUser != null && queryUser.equals(userId)) {
			queryVO.setSequence(Integer.parseInt(sequence));
			responseVO = queryService.updateQuery(queryVO);
		} else {
			queryVO.setSequence(Integer.parseInt(sequence));
			responseVO = queryService.createQuery(queryVO);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/query?responseType=html");
		
		return mav;	
	}
	
	@Auth
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public ModelAndView submitQuery(HttpServletRequest request, HttpServletResponse response
			, @RequestParam(value="sequence", required=false) String sequence
			, @RequestParam(value="userId", required=false) String userId
			, @RequestParam(value="responseType", required=false) String responseType
			, @RequestParam(value="title", required=false) String title
			, @RequestParam(value="query[]", required=false) List<String> query
			, @RequestParam(value="param[]", required=false) List<String> param
			, @RequestParam(value="databaseurl", required=false) String databaseurl
			, @RequestBody String requestBody) throws IOException {
		
		QueryVO2 queryVO = (QueryVO2) CommonUtil.StringToObject(requestBody, QueryVO2.class);
		
		QueryResultVO queryResultVO = queryService.userCommand(queryVO);
		
		HttpSession session = request.getSession();
		
		Gson gson = new Gson();
		String json = gson.toJson(queryResultVO);
		response.getWriter().write(json);
		return null;
	}
}