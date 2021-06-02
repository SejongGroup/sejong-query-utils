package com.kakao.datavisualization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.datavisualization.dao.LoginDAO;
import com.kakao.datavisualization.model.DataResponseBody;
import com.kakao.datavisualization.model.MemberVO;
import com.kakao.datavisualization.model.ResultVO;

@Service
public class LoginService {
	@Autowired
	LoginDAO loginDAO;

	public DataResponseBody actionLogin(MemberVO member) {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		
		if (loginDAO.actionLogin(member) <= 0) {
			/* 아이디 없음 에러 처리 */
			System.out.println("error");
			resultVO.setResultCode("999");
			resultVO.setResultMessage("실패");
		} else {
			resultVO.setResultCode("000");
			resultVO.setResultMessage("성공");
		}
		
		responseVO.setMember(member);
		responseVO.setResult(resultVO);
		
		return responseVO;
	}

	public DataResponseBody register(MemberVO member) {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		
		if (loginDAO.register(member) <= 0) {
			/* 회원가입 에러 처리 */
			System.out.println("error");
			resultVO.setResultCode("999");
			resultVO.setResultMessage("실패");
		} else {
			resultVO.setResultCode("000");
			resultVO.setResultMessage("성공");
		}
		
		responseVO.setMember(member);
		responseVO.setResult(resultVO);
		
		return responseVO;
	}
	
	
}
