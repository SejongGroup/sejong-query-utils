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
import com.kakao.datavisualization.model.SqlDriverVO;
import com.kakao.datavisualization.model.QueryVO2;
import com.kakao.datavisualization.service.QueryService;
import com.kakao.datavisualization.service.SqlDriverService;
import com.kakao.datavisualization.util.CommonUtil;

@Controller
@RequestMapping("/sqldriver")
public class SqlDriverController {
	@Autowired
	SqlDriverService sqlDriverService;
	
	@Auth
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createQueryJSP(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="responseType", required=false) String responseType) throws IOException {
				
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		DataResponseBody responseVO = new DataResponseBody();
		responseVO.setMember(member);
		
		mav.addObject("data", responseVO);
		mav.setViewName("sqldriver/create");
		return mav;	
	}
	
	@Auth
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public ModelAndView submitQuery(HttpServletRequest request, HttpServletResponse response
			, @RequestBody String requestBody) throws IOException {
		
		SqlDriverVO sqlDriverVO = (SqlDriverVO) CommonUtil.StringToObject(requestBody, SqlDriverVO.class);
		DataResponseBody responseVO = sqlDriverService.createDriver(sqlDriverVO);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/query?responseType=html");
		
		return mav;	
	}

}