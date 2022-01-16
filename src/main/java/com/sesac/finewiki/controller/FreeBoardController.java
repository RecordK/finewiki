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
import com.sesac.finewiki.vo.FreeVo;
import com.sesac.finewiki.service.BoardService;
import com.sesac.finewiki.service.FreeService;

@Controller
@RequestMapping("/board/free")
public class FreeBoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardPagingSearchController.class);
	private final FreeService freeService;

	@Inject
	public FreeBoardController(FreeService freeService) {
		this.freeService = freeService;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {
		logger.info("search writeGET() called...");
		return "board/free/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(FreeVo freeVo, RedirectAttributes redirectAttributes) throws Exception {
		logger.info("search writePOST() called...");
		freeService.create(freeVo);
		redirectAttributes.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/free/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search list() called ...");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(searchCriteria);
		pageMaker.setTotalCount(freeService.countFrees(searchCriteria));
		pageMaker.setTotalCount(freeService.countSearchedFrees(searchCriteria));
		model.addAttribute("Frees", freeService.listCriteria(searchCriteria));
		model.addAttribute("Frees", freeService.listSearch(searchCriteria));
		model.addAttribute("pageMaker", pageMaker);
		return "board/free/list";
	}

	@RequestMapping(value = "/listCriteria", method = RequestMethod.GET)
	public String listCriteria(Model model, Criteria criteria) throws Exception {
		logger.info("listCriteria ...");
		model.addAttribute("Frees", freeService.listCriteria(criteria));
		return "/board/free/list_criteria";
	}

	// 조화 페이지
	@RequestMapping(value = "/read", method = RequestMethod.GET)

	public String read(@RequestParam("data_no") int data_no,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search read() called...");
		model.addAttribute("free", freeService.read(data_no));
		return "board/free/read";
	}

	// 수정 페이지

	@RequestMapping(value = "/modify", method = RequestMethod.GET)

	public String modifyGET(@RequestParam("data_no") int data_no,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search modifyGet()called ...");
		logger.info(searchCriteria.toString());
		model.addAttribute("free", freeService.read(data_no));
		return "board/free/modify";
	}

	// 수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(FreeVo freeVo, SearchCriteria searchCriteria, RedirectAttributes redirectAttributes)
			throws Exception {
		logger.info("search modifyPOST() called ...");
		freeService.update(freeVo);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
		redirectAttributes.addFlashAttribute("msg", "modSuccess");
		return "redirect:/board/free/list";
	}
	// 삭제 처리

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("data_no") int data_no, SearchCriteria searchCriteria,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.info("search remove() called ...");
		freeService.delete(data_no);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
		redirectAttributes.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/free/list";

	}
}