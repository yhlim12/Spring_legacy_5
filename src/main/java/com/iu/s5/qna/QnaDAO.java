package com.iu.s5.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s5.board.BoardDAO;
import com.iu.s5.board.BoardVO;
import com.iu.s5.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.iu.s5.qna.QnaDAO.";
	

	public int boardReplyUpdate(BoardVO boardVO)throws Exception{
		return sqlSession.update(NAMESPACE+"boardReplyUpdate",boardVO);
	}
	
	public int boardReply(BoardVO boardVO)throws Exception{
		return sqlSession.insert(NAMESPACE+"boardReply",boardVO);
	}
	
	@Override
	public long boardCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardCount",pager);
	}

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"boardList",pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardSelect",num);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return sqlSession.delete(NAMESPACE+"boardDelete", num);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return sqlSession.update(NAMESPACE+"boardUpdate", boardVO);
	}

	@Override
	public int hitUpdate(long num) throws Exception {
		return sqlSession.update(NAMESPACE+"hitUpdate", num);
	}
	

}
