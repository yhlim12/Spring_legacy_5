package com.iu.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.board.BoardVO;

@Controller
public class QnaController {
	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String getBoard()throws Exception {
		return "qna";
	}
	
	//List
	@RequestMapping(value="qnaList", method = RequestMethod.GET)
	public ModelAndView boardList(@RequestParam(defaultValue = "1") int curPage, ModelAndView mv)throws Exception{

		List<BoardVO> ar =  qnaService.boardList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		
		return mv;
		
	}
}
