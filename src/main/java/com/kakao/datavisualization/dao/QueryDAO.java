package com.kakao.datavisualization.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kakao.datavisualization.model.BoardVO;
import com.kakao.datavisualization.model.MemberVO;
import com.kakao.datavisualization.model.QueryVO2;
import com.kakao.datavisualization.model.QueryVO2;

@Repository
public class QueryDAO {
	@Autowired protected SqlSession sqlSession;


	public List<QueryVO2> getQuery(MemberVO member) {
		return sqlSession.selectList("query.getQuery", member);
	}

	public Integer getSequence() {
		return sqlSession.selectOne("query.querySequence");
	}

	public Integer createQuery(HashMap<String, String> hashMap) {
		return sqlSession.insert("query.createQuery", hashMap);
	}

	public List<QueryVO2> selectQuery(String sequence) {
		return sqlSession.selectList("query.selectQuery", sequence);
	}

	public int updateQuery(HashMap<String, String> hashMap) {
		return sqlSession.update("query.updateQuery", hashMap);
	}

	public String commandCUD(HashMap<String, String> hm, String dmlString) {
		if (dmlString.equals("INSERT")) {
			return String.valueOf(sqlSession.insert("query.commandInsert", hm));
		} else if (dmlString.equals("DELETE")) {
			return String.valueOf(sqlSession.delete("query.commandDelete", hm));
		} else if (dmlString.equals("UPDATE")) {
			return String.valueOf(sqlSession.update("query.commandUpdate", hm));
		}
		return null;
	}

	public List<Map<String, Object>> commandR(HashMap<String, String> hm) {
		return sqlSession.selectList("query.commandSelect", hm);
	}
	
}
