package com.kakao.datavisualization.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kakao.datavisualization.model.BoardVO;
import com.kakao.datavisualization.model.DataResponseBody;
import com.kakao.datavisualization.model.MemberVO;
import com.kakao.datavisualization.model.ResultVO;
import com.kakao.datavisualization.service.BoardService;
import com.kakao.datavisualization.util.CommonUtil;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardservice;
	
	/**
	 * @FreeBoard
	 * 자유게시판은 누구나 다 볼수 있으며, board/*.jsp 파일로 정해져 있음
	 */
	@RequestMapping(value="/freeboard", method=RequestMethod.GET)
	public ModelAndView freeBoardJSP(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="responseType", required=false) String responseType) throws IOException {
		DataResponseBody responseVO = boardservice.freeBoardList();

		if (responseType == null || !responseType.equals("html")) {
			Gson gson = new Gson();
			String json = gson.toJson(responseVO);
			response.getWriter().write(json);
			return null;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", responseVO);
		mav.setViewName("board/freeboard");
		return mav;	
	}
	
	@RequestMapping(value="/freeboard/write", method=RequestMethod.GET)
	public ModelAndView freeBoardWriteJSP(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody) {
		
		/* 세션 확인 */
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if (member == null) {
			/* 세션이 없으니까 종료해야하긴하는데 나중에 구현할 꺼임 */
		}
		
		/* TODO : 권한이 있는지 확인 */
		
		/* 파라미터 값이 있으면 수정 */
		ModelAndView mav = new ModelAndView();
		
		/* 파라미터 값이 없으면 생성 */
		
		mav.setViewName("board/boardwrite");
		return mav;	
	}
	
	@RequestMapping(value="/freeboard/action", method=RequestMethod.POST)
	public ModelAndView freeBoardWrite(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="responseType", required=false) String responseType) throws JsonParseException, JsonMappingException, IOException {
		/* 세션 확인 */
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if (member == null) {
			/* 세션이 없으니까 종료해야하긴하는데 나중에 구현할 꺼임 */
		}
		
		/* TODO : 권한이 있는지 확인 */
		
		/* 글 쓰기 처리 */
		BoardVO boardVO = (BoardVO) CommonUtil.StringToObject(requestBody, BoardVO.class);
		
		DataResponseBody responseVO = boardservice.freeBoardWrite(boardVO);

		if (responseType == null || !responseType.equals("html")) {
			Gson gson = new Gson();
			String json = gson.toJson(responseVO);
			response.getWriter().write(json);
			return null;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/freeboard?responseType=html");
		return mav;	
	}
	
	@RequestMapping(value="/freeboard/view", method=RequestMethod.GET)
	public ModelAndView freeBoardView(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="bno", required=false) String bno) throws JsonParseException, JsonMappingException, IOException {
		DataResponseBody responseVO = boardservice.freeBoardView(bno);
		
		ModelAndView mav = new ModelAndView();
		
		Gson gson = new Gson();
		String json = gson.toJson(responseVO);
		
		System.out.println(json);
		
		mav.addObject("data", responseVO);
		mav.setViewName("board/boardview");
		return mav;
	}
	
	@RequestMapping(value="/freeboard/delete", method=RequestMethod.POST)
	public ModelAndView freeBoardDelete(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="responseType", required=false) String responseType) throws JsonParseException, JsonMappingException, IOException {
		/* 세션 확인 */
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if (member == null) {
			/* 세션이 없으니까 종료해야하긴하는데 나중에 구현할 꺼임 */
		}
		
		/* TODO : 권한이 있는지 확인 */
		
		BoardVO boardVO = (BoardVO) CommonUtil.StringToObject(requestBody, BoardVO.class);		
		DataResponseBody responseVO = boardservice.freeBoardDelete(boardVO);

		if (responseType == null || !responseType.equals("html")) {
			Gson gson = new Gson();
			String json = gson.toJson(responseVO);
			response.getWriter().write(json);
			return null;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/freeboard?responseType=html");
		return mav;	
	}
	
	@RequestMapping(value="/freeboard/modify", method=RequestMethod.POST)
	public ModelAndView freeBoardModify(HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody, @RequestParam(value="responseType", required=false) String responseType) throws JsonParseException, JsonMappingException, IOException {
		/* 세션 확인 */
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if (member == null) {
			/* 세션이 없으니까 종료해야하긴하는데 나중에 구현할 꺼임 */
		}
		
		/* 권한이 있는지 확인 하고 */
		BoardVO boardVO = (BoardVO) CommonUtil.StringToObject(requestBody, BoardVO.class);		
		DataResponseBody responseVO = boardservice.freeBoardModify(boardVO);
		
		if (responseType == null || !responseType.equals("html")) {
			Gson gson = new Gson();
			String json = gson.toJson(responseVO);
			response.getWriter().write(json);
			return null;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/freeboard?responseType=html");
		return mav;	
	}
	
	
	
	/**
	 * 다른 게시판이 올수도 있겠죠? 그래서 여기는 비워둡니다.
	 */
	
}
