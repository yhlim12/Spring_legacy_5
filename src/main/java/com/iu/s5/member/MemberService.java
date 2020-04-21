package com.iu.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iu.s5.util.Pager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberVO> memberList(Pager pager)throws Exception{
		
		pager.makeRow();
		long totalCount = memberDAO.memberCount(pager);
		pager.makePage(totalCount);
		return memberDAO.memberList(pager);
	}
	
	public int memberJoin(MemberVO memberVO)throws Exception{
		return memberDAO.memberJoin(memberVO);
	}
	
	public MemberVO memberLogin(MemberVO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	
	public int memberUpdate(MemberVO memberVO)throws Exception{
		return memberDAO.memberUpdate(memberVO);
	}
	
	public int memberDelete(MemberVO memberVO) throws Exception{
		return memberDAO.memberDelete(memberVO);
	}
}
