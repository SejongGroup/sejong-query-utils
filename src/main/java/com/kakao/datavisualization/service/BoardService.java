package com.kakao.datavisualization.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.datavisualization.dao.BoardDAO;
import com.kakao.datavisualization.model.BoardVO;
import com.kakao.datavisualization.model.DataResponseBody;
import com.kakao.datavisualization.model.ResultVO;

@Service
public class BoardService {
	
	@Autowired
	BoardDAO boardDao;
	
	public DataResponseBody freeBoardList() {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode("000");
		resultVO.setResultMessage("성공");
		
		responseVO.setBoard(boardDao.freeBoardList());
		responseVO.setResult(resultVO);
		
		return responseVO;
	}

	public DataResponseBody freeBoardWrite(BoardVO boardVO) {
		DataResponseBody responseVO = new DataResponseBody();
		
		int result = boardDao.freeBoardWrite(boardVO);
		
		ResultVO resultVO = new ResultVO();
		if (result <= 0) {
			resultVO.setResultCode("999");
			resultVO.setResultMessage("실패");
		} else {
			resultVO.setResultCode("000");
			resultVO.setResultMessage("성공");
		}
		responseVO.setResult(resultVO);
		return responseVO;
	}

	public DataResponseBody freeBoardView(String bno) {
		DataResponseBody responseVO = new DataResponseBody();
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode("000");
		resultVO.setResultMessage("성공");
		responseVO.setResult(resultVO);
		
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("bno", Integer.parseInt(bno));
		BoardVO boardVO = boardDao.freeBoardView(param);
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList.add(boardVO);
		
		responseVO.setBoard(boardList);
		return responseVO;
	}

	public DataResponseBody freeBoardDelete(BoardVO boardVO) {
		DataResponseBody responseVO = new DataResponseBody();
		
		int result = boardDao.freeBoardDelete(boardVO);
		
		ResultVO resultVO = new ResultVO();
		if (result <= 0) {
			resultVO.setResultCode("999");
			resultVO.setResultMessage("실패");
		} else {
			resultVO.setResultCode("000");
			resultVO.setResultMessage("성공");
		}
		responseVO.setResult(resultVO);
		return responseVO;
	}

	public DataResponseBody freeBoardModify(BoardVO boardVO) {
		DataResponseBody responseVO = new DataResponseBody();
		
		int result = boardDao.freeBoardModify(boardVO);
		
		ResultVO resultVO = new ResultVO();
		if (result <= 0) {
			resultVO.setResultCode("999");
			resultVO.setResultMessage("실패");
		} else {
			resultVO.setResultCode("000");
			resultVO.setResultMessage("성공");
		}
		responseVO.setResult(resultVO);
		return responseVO;
	}
}
