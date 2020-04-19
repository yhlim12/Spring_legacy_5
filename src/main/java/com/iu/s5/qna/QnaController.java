package com.iu.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.board.BoardVO;
import com.iu.s5.notice.NoticeVO;

@Controller
@RequestMapping("/qna/**")
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
	
	//writter
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(QnaVO qnaVO, ModelAndView mv) throws Exception {

		int result = qnaService.boardWrite(qnaVO);
		if (result > 0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("result", "Write Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	//select
	@RequestMapping(value = "qnaSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(long num) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO = qnaService.boardSelect(num);
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	// Delete
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(long num) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./qnaList");
		int result = qnaService.boardDelete(num);

		if(result>0) {
			mv.addObject("result", "Delete Success");
			
		}else {
			mv.addObject("result", "Delete Fail");
		}
		
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	// Update
		@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
		public String boardUpdate(long num, Model model) throws Exception {
			ModelAndView mv = new ModelAndView();
			BoardVO boardVO = qnaService.boardSelect(num);
			model.addAttribute("vo", boardVO);
			return "board/boardUpdate";
		}

		@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
		public String boardUpdate(QnaVO qnaVO)throws Exception{
			int result = qnaService.boardUpdate(qnaVO);
		
			result=0;
			String path="";
			if(result>0) {
				path="redirect:./qnaList";
			}else {
				path="redirect:./qnaSelect?num="+qnaVO.getNum();	
			}
			return path;
		}

	
}
