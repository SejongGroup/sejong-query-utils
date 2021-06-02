package com.kakao.datavisualization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.datavisualization.dao.LoginDAO;
import com.kakao.datavisualization.dao.SqlDriverDAO;
import com.kakao.datavisualization.model.DataResponseBody;
import com.kakao.datavisualization.model.MemberVO;
import com.kakao.datavisualization.model.ResultVO;
import com.kakao.datavisualization.model.SqlDriverVO;

@Service
public class SqlDriverService {
	@Autowired
	SqlDriverDAO sqlDriverDAO;

	/**
	 * @methodName	: createDriver
	 * @author 		: JH.KIM
	 * @date		: 2021. 6. 2.
	 * @description : 
	 * @param sqlDriverVO
	 * @return
	 */
	public DataResponseBody createDriver(SqlDriverVO sqlDriverVO) {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		
		if (sqlDriverDAO.createDriver(sqlDriverVO) <= 0) {
			/* 아이디 없음 에러 처리 */
			System.out.println("error");
			resultVO.setResultCode("999");
			resultVO.setResultMessage("실패");
		} else {
			resultVO.setResultCode("000");
			resultVO.setResultMessage("성공");
		}

		responseVO.setResult(resultVO);
		return responseVO;
	}

	/**
	 * @methodName	: selectDriver
	 * @author 		: JH.KIM
	 * @date		: 2021. 6. 2.
	 * @description : 
	 * @return
	 */
	public List<SqlDriverVO> selectDriver() {
		return sqlDriverDAO.selectDriver();
	}
	
}
