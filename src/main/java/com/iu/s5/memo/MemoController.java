package com.iu.s5.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.util.Pager;

@Controller
@RequestMapping("/memo/**")
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	@GetMapping("getList")
	public void getList(Pager pager, Model model)throws Exception{
	 	List<MemoVO> ar = memoService.memoList(pager);
	 	model.addAttribute("list", ar);
	 	
	}
	
	@GetMapping("memoList")
	public void memoList(Pager pager)throws Exception{
		memoService.memoList(pager);
	}
	
	@PostMapping("memoInsert")
	@ResponseBody
	public int memoInsert(MemoVO memoVO)throws Exception{
//		ModelAndView mv = new ModelAndView();
		int result = memoService.memoInsert(memoVO);
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
		return result;
		
	}
	
}
