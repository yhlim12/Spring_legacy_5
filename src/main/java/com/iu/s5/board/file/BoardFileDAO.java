package com.iu.s5.board.file;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDAO {
	
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE = "com.iu.s5.board.file.BoardFileDAO.";
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO)throws Exception{
		return session.selectOne(NAMESPACE+"fileSelect",boardFileVO);
	}
	
	public int fileInsert(BoardFileVO boardFileVO) throws Exception{
		return session.insert(NAMESPACE+"fileInsert",boardFileVO);
	}
	public int fileDelete(BoardFileVO boardFileVO)throws Exception{
		return session.delete(NAMESPACE+"fileDelete",boardFileVO);
	}
	public List<BoardFileVO> fileList(long num)throws Exception{
		return session.selectList(NAMESPACE+"fileList",num);
	}
	public int fileListDelete(long num)throws Exception{
		return session.delete(NAMESPACE+"fileListDelete",num);
	}
}
