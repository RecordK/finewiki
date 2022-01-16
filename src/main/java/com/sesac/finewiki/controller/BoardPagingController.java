package com.sesac.finewiki.controller;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.PageMaker;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.service.BoardService;

@Controller
@RequestMapping("/board/paging")
public class BoardPagingController {
	private static final Logger logger = LoggerFactory.getLogger(BoardPagingController.class);
	private final BoardService boardService;

	@Inject
	public BoardPagingController(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {
		logger.info("paging writeGET() called...");
		return "board/paging/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(BoardVo vo, RedirectAttributes redirectAttributes) throws Exception {
		logger.info("paging writePOST() called...");
		boardService.create(vo);
		redirectAttributes.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/paging/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, Criteria criteria) throws Exception {
		logger.info("paging list() called ...");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(boardService.countBoards(criteria));
		model.addAttribute("boards", boardService.listCriteria(criteria));
		model.addAttribute("pageMaker", pageMaker);
		return "board/paging/list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(@RequestParam("data_no") int data_no, @ModelAttribute("criteria") Criteria criteria,
			Model model) throws Exception {
		logger.info("paging read() called ...");
		model.addAttribute("board", boardService.read(data_no));
		return "board/paging/read";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("data_no") int data_no, @ModelAttribute("criteria") Criteria criteria,
			Model model) throws Exception {
		logger.info("paging modifyGet() called ...");
		model.addAttribute("board", boardService.read(data_no));
		return "board/paging/modify";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVo vo, Criteria criteria, RedirectAttributes redirectAttributes)
			throws Exception {
		logger.info("paging modifyPOST() called ...");
		boardService.update(vo);
		redirectAttributes.addAttribute("page", criteria.getPage());
		redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
		redirectAttributes.addFlashAttribute("msg", "modSuccess");
		return "redirect:/board/paging/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("data_no") int data_no, Criteria criteria,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.info("paging remove() called ...");
		boardService.delete(data_no);
		redirectAttributes.addAttribute("page", criteria.getPage());
		redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
		redirectAttributes.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/paging/list";
	}
}
