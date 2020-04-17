package com.iu.s5.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s5.board.BoardDAO;
import com.iu.s5.board.BoardVO;

@Repository
public class QnaDAO implements BoardDAO{
	
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.iu.s5.qna.QnaDAO.";
	

	@Override
	public long boardCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardCount");
	}

	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) throws Exception {
		return sqlSession.selectList(NAMESPACE+"boardList",map);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hitUpdate(long num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
