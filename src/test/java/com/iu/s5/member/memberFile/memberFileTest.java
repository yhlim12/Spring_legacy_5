package com.iu.s5.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class memberFileTest extends AbstractTestCase{

	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Test
	public void fileInsertTest() throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("test");
		memberFileVO.setFilename("test_file");
		memberFileVO.setOriname("test_ori");
		int result = memberFileDAO.fileInsert(memberFileVO);
		assertEquals(1,result);
		
		
	}

}
