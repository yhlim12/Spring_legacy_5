package com.iu.s5.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s5.member.memberPage.MemberPager;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s5.member.MemberDAO.";
	
	public long memberCount(MemberPager memberPager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberCount",memberPager);
	}
	
	public List<MemberVO> memberList(MemberPager memberPager)throws Exception{
		return sqlSession.selectList(NAMESPACE+"memberList",memberPager);
	}
	
	public int memberJoin(MemberVO memberVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memberJoin",memberVO);
	}
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberVO);
	}

}
