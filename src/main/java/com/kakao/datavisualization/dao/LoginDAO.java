package com.kakao.datavisualization.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kakao.datavisualization.model.BoardVO;
import com.kakao.datavisualization.model.MemberVO;

@Repository
public class LoginDAO {
	@Autowired protected SqlSession sqlSession;

	public Integer actionLogin(MemberVO member) {
		return sqlSession.selectOne("login.actionLogin", member);
	}

	public Integer register(MemberVO member) {
		return sqlSession.insert("login.register", member);
	}

	
	
}
