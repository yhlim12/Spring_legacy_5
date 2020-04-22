package com.iu.s5.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.member.memberFile.MemberFileDAO;
import com.iu.s5.member.memberFile.MemberFileVO;
import com.iu.s5.util.Pager;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "memberList", method = RequestMethod.GET)
	public ModelAndView memberList(Pager pager, ModelAndView mv) throws Exception {

		List<MemberVO> ar = memberService.memberList(pager);
		mv.addObject("list", ar);
		mv.addObject("memberPager", pager);
		mv.setViewName("member/memberList");
		return mv;
	}

	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public ModelAndView memberJoin(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberJoin");
		return mv;
	}

	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile avatar, ModelAndView mv, HttpSession session) throws Exception {

		
		int result = memberService.memberJoin(memberVO, avatar,session);
		if (result > 0) {
			mv.setViewName("redirect:./memberList");
		} else {
			mv.addObject("result", "Join Fail");
			mv.addObject("path", "./memberList");
			mv.setViewName("common/result");

		}

		return mv;
	}

	@GetMapping("memberLogin")
	public void memberLogin(Model model, @CookieValue(value = "cId", required = false) String cId) {
		System.out.println(cId);
		/* model.addAttribute("cId",cId); */
	}

	@PostMapping("memberLogin")
	public ModelAndView memberLogin(ModelAndView mv, MemberVO memberVO, HttpSession session, String remember,
			HttpServletResponse response) throws Exception {

		Cookie cookie = new Cookie("cId", "");

		if (remember != null) {
			/* cookie = new Cookie("cid", memberVO.getId()); */
			cookie.setValue(memberVO.getId());
		}
		/* cookie.setMaxAge(30); */

		response.addCookie(cookie);

		memberVO = memberService.memberLogin(memberVO);

		if (memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		} else {
			mv.addObject("result", "Login Fail");
			mv.addObject("path", "./memberJoin");
			mv.setViewName("common/result");
		}

		return mv;
	}

	@RequestMapping(value = "memberMypage")
	public void memberPage(HttpSession session, Model model) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		MemberFileVO memberFileVO = memberService.fileSelect(memberVO.getId());
		model.addAttribute("file", memberFileVO);
	}

	@RequestMapping(value = "memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}

	@RequestMapping(value = "memberUpdate")
	public void memberUpdate() {

	}

	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView memberUpdate(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		String id = ((MemberVO) session.getAttribute("member")).getId();
		memberVO.setId(id);

		int result = memberService.memberUpdate(memberVO);

		if (result > 0) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:./memberMypage");
		} else {
			mv.addObject("result", "Update Fail");
			mv.addObject("path", "./memberMypage");
			mv.setViewName("common/result");
		}

		return mv;
	}

	@RequestMapping(value = "memberDelete")
	public ModelAndView memberDelete(ModelAndView mv, HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		int result = memberService.memberDelete(memberVO);
		if (result > 0) {
			session.invalidate();
			mv.addObject("result", "Delete Success");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		} else {
			mv.addObject("result", "Delete Fail");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		}

		return mv;
	}
	
	@GetMapping("fileDelete")
	public String fileDelete(HttpSession session)throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		int result = memberService.fileDelete(memberVO.getId(), session);
		return "redirect:./memberMypage";
	}

}
