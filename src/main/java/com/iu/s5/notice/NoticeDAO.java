package com.iu.s5.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s5.board.BoardDAO;
import com.iu.s5.board.BoardVO;

@Repository
public class NoticeDAO implements BoardDAO{

	@Override
	public long boardCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardCount");		
	}

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s5.notice.NoticeDAO.";

	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) throws Exception {
		return sqlSession.selectList(NAMESPACE+"boardList", map);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardSelect",num);
	}


	@Override
	public int hitUpdate(long num) throws Exception {
		return sqlSession.update(NAMESPACE+"hitUpdate", num);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
		
	}
	
	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return sqlSession.update(NAMESPACE+"boardUpdate", boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return sqlSession.delete(NAMESPACE+"boardDelete", num);
	}

}
