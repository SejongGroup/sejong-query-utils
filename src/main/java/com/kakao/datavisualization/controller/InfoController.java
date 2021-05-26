package com.kakao.datavisualization.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kakao.datavisualization.model.MemberVO;

@Controller
@RequestMapping("/info")
public class InfoController {

	/* Info Home View */
	@RequestMapping(value="")
	public ModelAndView infoMain(HttpServletRequest request, HttpServletResponse response, MemberVO responseVo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("info/index");
		return mav;
	}
}
