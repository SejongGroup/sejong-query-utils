package com.kakao.datavisualization.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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
import com.kakao.datavisualization.model.ResultVO;
import com.kakao.datavisualization.service.LoginService;
import com.kakao.datavisualization.util.CommonUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="")
	public ModelAndView loginJSP(HttpServletRequest request, HttpServletResponse response, MemberVO responseVo) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		
		if (member == null) {
			mav.setViewName("login/login");
		} else {
			mav.setViewName("redirect:/query?responseType=html");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/action", method=RequestMethod.POST)
	public ModelAndView loginActive(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="responseType", required=false) String responseType) throws JsonParseException, JsonMappingException, IOException {
		
		MemberVO member = (MemberVO) CommonUtil.StringToObject(requestBody, MemberVO.class);
		DataResponseBody responseVO = loginService.actionLogin(member);

		if( responseVO.getResult().getResultCode().equals("000") ) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("member", member);
		}


		if (responseType == null || !responseType.equals("html")) {
			Gson gson = new Gson();
			
			String json = gson.toJson(responseVO);
			response.getWriter().write(json);
			return null;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerJSP(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody) throws JsonParseException, JsonMappingException, IOException {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/register");
		return mav;
	}
	
	@RequestMapping(value="/registeraction", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="responseType", required=false) String responseType) throws JsonParseException, JsonMappingException, IOException {
		
		MemberVO member = (MemberVO) CommonUtil.StringToObject(requestBody, MemberVO.class);
		DataResponseBody responseVO = loginService.register(member);
		
		if (responseType == null || !responseType.equals("html")) {
			Gson gson = new Gson();
			String json = gson.toJson(responseVO);
			response.getWriter().write(json);
			return null;
		}
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/login");
		return mav;
	}
	
}
