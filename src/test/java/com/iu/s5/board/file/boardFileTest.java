package com.iu.s5.board.file;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class boardFileTest extends AbstractTestCase {

	@Autowired
	private BoardFileDAO boardFileDAO;
	
	@Test
	public void fileInsertTest()throws Exception{
		BoardFileVO boardFileVO = new BoardFileVO();
		boardFileVO.setNum(1);
		boardFileVO.setFileName("test");
		boardFileVO.setOriName("test");
		boardFileVO.setBoard(1);
		int result = boardFileDAO.fileInsert(boardFileVO);
		assertEquals(1,result);
	}
	
}
