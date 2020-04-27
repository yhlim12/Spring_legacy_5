package com.iu.s5.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s5.member.memberFile.MemberFileDAO;
import com.iu.s5.member.memberFile.MemberFileVO;
import com.iu.s5.util.FileSaver;
import com.iu.s5.util.Pager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private MemberFileDAO memberFileDAO;
	@Autowired
	private FileSaver fileSaver;
	
	public List<MemberVO> memberList(Pager pager)throws Exception{
		
		pager.makeRow();
		long totalCount = memberDAO.memberCount(pager);
		pager.makePage(totalCount);
		return memberDAO.memberList(pager);
	}
	
	public int memberJoin(MemberVO memberVO, MultipartFile avatar, HttpSession session)throws Exception{
		//HDD에 저장 resources/memberUpload/
		//	1. 파일을 HDD에 저장
		String path = session.getServletContext().getRealPath("/resources/memberUpload");
		System.out.println(path);
		String fileName = fileSaver.saveByUtils(avatar, path);
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		memberFileVO.setFilename(fileName);
		memberFileVO.setOriname(avatar.getOriginalFilename());
		
		//2. 파일명을 DB에 저장
		int result = memberDAO.memberJoin(memberVO);
		result = memberFileDAO.fileInsert(memberFileVO);
		
		return result;
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
	
	public int fileDelete(String id, HttpSession session)throws Exception{
		MemberFileVO memberFileVO = memberFileDAO.fileSelect(id);
		int result = memberFileDAO.fileDelete(id);
		String path = session.getServletContext().getRealPath("/resources/memberUpload");
		
		if(result>0) {
			result = fileSaver.deleteFile(memberFileVO.getFilename(), path);
		}
		return result;
	}
	
	public MemberVO memberIdCheck(MemberVO memberVO)throws Exception{
		return memberDAO.memberIdCheck(memberVO);
	}
	
	public int memberDeletes(List<String> list)throws Exception{
		return memberDAO.memberDeletes(list);
	}
}
