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
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardPagingSearchController.class);
	private final BoardService boardService;

	@Inject
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {
		logger.info("search writeGET() called...");
		return "board/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(BoardVo vo, RedirectAttributes redirectAttributes) throws Exception {
		logger.info("search writePOST() called...");
		boardService.create(vo);
		redirectAttributes.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search list() called ...");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(searchCriteria);
		pageMaker.setTotalCount(boardService.countBoards(searchCriteria));
		pageMaker.setTotalCount(boardService.countSearchedBoards(searchCriteria));
		model.addAttribute("boards", boardService.listCriteria(searchCriteria));
		model.addAttribute("boards", boardService.listSearch(searchCriteria));
		model.addAttribute("pageMaker", pageMaker);
		return "board/list";
	}

	@RequestMapping(value = "/listCriteria", method = RequestMethod.GET)
	public String listCriteria(Model model, Criteria criteria) throws Exception {
		logger.info("listCriteria ...");
		model.addAttribute("boards", boardService.listCriteria(criteria));
		return "/board/list_criteria";
	}

	// 조화 페이지
	@RequestMapping(value = "/read", method = RequestMethod.GET)

	public String read(@RequestParam("data_no") int data_no,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search read() called...");
		model.addAttribute("board", boardService.read(data_no));
		return "board/read";
	}

	// 수정 페이지

	@RequestMapping(value = "/modify", method = RequestMethod.GET)

	public String modifyGET(@RequestParam("data_no") int data_no,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search modifyGet()called ...");
		logger.info(searchCriteria.toString());
		model.addAttribute("board", boardService.read(data_no));
		return "board/modify";
	}

	// 수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVo vo, SearchCriteria searchCriteria, RedirectAttributes redirectAttributes)
			throws Exception {
		logger.info("search modifyPOST() called ...");
		boardService.update(vo);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
		redirectAttributes.addFlashAttribute("msg", "modSuccess");
		return "redirect:/board/list";
	}
	// 삭제 처리

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("data_no") int data_no, SearchCriteria searchCriteria,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.info("search remove() called ...");
		boardService.delete(data_no);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
		redirectAttributes.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/list";

	}
}