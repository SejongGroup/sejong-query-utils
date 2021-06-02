package com.kakao.datavisualization.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kakao.datavisualization.model.BoardVO;
import com.kakao.datavisualization.model.SqlDriverVO;

@Repository
public class SqlDriverDAO {
	@Autowired protected SqlSession sqlSession;

	public int createDriver(SqlDriverVO sqlDriverVO) {
		return sqlSession.insert("sqldriver.createdriver", sqlDriverVO);
	}

	/**
	 * @methodName	: selectDriver
	 * @author 		: JH.KIM
	 * @date		: 2021. 6. 2.
	 * @description : 
	 * @return
	 */
	public List<SqlDriverVO> selectDriver() {
		return sqlSession.selectList("sqldriver.selectDriver");
	}

	/**
	 * @methodName	: selectDriver
	 * @author 		: JH.KIM
	 * @date		: 2021. 6. 2.
	 * @description : 
	 * @param databaseurl
	 * @return
	 */
	public SqlDriverVO selectDriver(String databaseurl) {
		return sqlSession.selectOne("sqldriver.selectDriverOne", databaseurl);
	}
}
