package com.iu.s5.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase{
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void daoIsnull() {
		assertNotNull(noticeDAO);
	}
	
	@Test
	public void boardWriteTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("testTitle");
		noticeVO.setWriter("test writer");
		noticeVO.setContents("test contents");
		int result = noticeDAO.boardWrite(noticeVO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void boardUpdateTest()throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("tt");
		noticeVO.setContents("ttt");
		noticeVO.setNum(2);
	
		int result = noticeDAO.boardUpdate(noticeVO);
		
		assertNotEquals(0, result);
	}
	
	@Test
	public void hitUpdateTest()throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(2);
		
		int result = noticeDAO.hitUpdate(noticeVO);
		
		assertNotEquals(0, result);
		
	}
	
	/*
	 * @Test public void boardDeleteTest() throws Exception{
	 * 
	 * 
	 * int result = noticeDAO.boardDelete(1);
	 * 
	 * assertNotEquals(0, result); }
	 */
	
	
}
