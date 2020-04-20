package com.iu.s5.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;
import com.iu.s5.board.BoardVO;

public class NoticeDAOTest extends AbstractTestCase{
	@Autowired
	private NoticeDAO noticeDAO;
	
	 @Test 
	 public void daoTest() throws Exception{ 
		this.boardWriteTest();
	 }

	

	public void daoIsnull() {
		assertNotNull(noticeDAO);
	}
	
	
	public void boardWriteTest() throws Exception {
		
		String writer="";
		String title="";
		String contents="";
		for(int i=0; i<150; i++) {
			NoticeVO noticeVO = new NoticeVO();
			if(i%3==0) {
				writer="iu";
				title="Alert";
				contents="Samsung";
			}else if(i%3==1) {
				writer="choa";
				title="Computer";
				contents="Apple";
			}else {
				writer="suzy";
				title="os";
				contents="Linux";
			}
			noticeVO.setTitle(title+i);
			noticeVO.setWriter(writer);
			noticeVO.setContents(contents+i);
			int result = noticeDAO.boardWrite(noticeVO);
			if(i==50 || i==100) {
				Thread.sleep(1000);
			}
		}
	}
	

	public void boardUpdateTest()throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("tt");
		noticeVO.setContents("ttt");
		noticeVO.setNum(2);
	
		int result = noticeDAO.boardUpdate(noticeVO);
		
		assertNotEquals(0, result);
	}
	

	public void hitUpdateTest()throws Exception{
		
		int result = noticeDAO.hitUpdate(2);
		
		assertNotEquals(0, result);
		
	}
	

	public BoardVO boardSelectTest()throws Exception{
		BoardVO boardVO = noticeDAO.boardSelect(2);
		
		assertNotNull(boardVO);
		
		return boardVO;
		
	}
	
	/*
	 * public List<BoardVO> boardListTest()throws Exception{ return
	 * noticeDAO.boardList(); }
	 */
	
	/*
	 * @Test public void boardDeleteTest() throws Exception{
	 * 
	 * 
	 * int result = noticeDAO.boardDelete(1);
	 * 
	 * assertNotEquals(0, result); }
	 */
	
	
}
