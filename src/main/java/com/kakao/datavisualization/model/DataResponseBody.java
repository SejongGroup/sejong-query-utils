package com.kakao.datavisualization.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonAutoDetect
public class DataResponseBody {
	private ResultVO result;
	private MemberVO member;
	private List<BoardVO> board;
	private List<QueryVO> query;
	private List<QueryVO2> query2;
	private List<SqlDriverVO> sqldriver;
	

	public ResultVO getResult() {
		return result;
	}
	public void setResult(ResultVO result) {
		this.result = result;
	}
	public MemberVO getMember() {
		return member;
	}
	public void setMember(MemberVO member) {
		this.member = member;
	}
	public List<BoardVO> getBoard() {
		return board;
	}
	public void setBoard(List<BoardVO> board) {
		this.board = board;
	}
	public List<QueryVO> getQuery() {
		return query;
	}
	public void setQuery(List<QueryVO> query) {
		this.query = query;
	}
	public List<QueryVO2> getQuery2() {
		return query2;
	}
	public void setQuery2(List<QueryVO2> query2) {
		this.query2 = query2;
	}
	public List<SqlDriverVO> getSqldriver() {
		return sqldriver;
	}
	public void setSqldriver(List<SqlDriverVO> sqldriver) {
		this.sqldriver = sqldriver;
	}
}
