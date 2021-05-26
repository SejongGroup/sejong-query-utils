package com.kakao.datavisualization.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kakao.datavisualization.model.BoardVO;

@Repository
public class BoardDAO {
	@Autowired protected SqlSession sqlSession;
	
	public List<BoardVO> freeBoardList() {
		return sqlSession.selectList("board.selectFreeBoard");
	}

	public int freeBoardWrite(BoardVO boardVO) {
		return sqlSession.insert("board.insertFreeBoard", boardVO);
	}

	public BoardVO freeBoardView(HashMap<String, Integer> param) {
		return sqlSession.selectOne("board.viewfreeBoard", param);
	}

	public int freeBoardDelete(BoardVO boardVO) {
		return sqlSession.delete("board.deleteFreeBoard", boardVO);
	}

	public int freeBoardModify(BoardVO boardVO) {
		return sqlSession.update("board.updateFreeBoard", boardVO);
	}
}
