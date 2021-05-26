package com.kakao.datavisualization;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kakao.datavisualization.model.MemberVO;
import com.kakao.datavisualization.util.CommonUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response, MemberVO responseVo) {
		logger.info(String.format("[%s] 에서 접근 요청이 들어왔습니다.", CommonUtil.getIp(request)));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response, MemberVO responseVo) {
		logger.info(String.format("[%s] 에서 접근 요청이 들어왔습니다.", CommonUtil.getIp(request)));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
}
