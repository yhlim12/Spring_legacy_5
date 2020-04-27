package com.iu.s5.board.file;

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
	public int fileDelete(long fileNum)throws Exception{
		return session.delete(NAMESPACE+"fileDelete",fileNum);
	}
	
}
