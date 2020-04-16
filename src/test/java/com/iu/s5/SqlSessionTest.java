package com.iu.s5;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SqlSessionTest extends AbstractTestCase {

	@Autowired
	private SqlSession sqlSession;
	
	//sql 세션이 제대로 만들어 지는지
	@Test
	public void sqlTest() throws Exception{
		assertNotNull(sqlSession);
	}
}
