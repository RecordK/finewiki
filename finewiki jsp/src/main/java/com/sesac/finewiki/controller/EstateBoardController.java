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
import com.sesac.finewiki.vo.EstateVo;
import com.sesac.finewiki.service.StockDashBoardService;
import com.sesac.finewiki.service.EstateService;

@Controller
@RequestMapping("/board/estate")
public class EstateBoardController {
	private static final Logger logger = LoggerFactory.getLogger(EstateBoardController.class);
	private final EstateService estateService;

	@Inject
	public EstateBoardController(EstateService estateService) {
		this.estateService = estateService;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {
		logger.info("search writeGET() called...");
		return "board/estate/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(EstateVo estateVo, RedirectAttributes redirectAttributes) throws Exception {
		logger.info("search writePOST() called...");
		estateService.create(estateVo);
		redirectAttributes.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/estate/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search list() called ...");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(searchCriteria);
		pageMaker.setTotalCount(estateService.countEstates(searchCriteria));
		pageMaker.setTotalCount(estateService.countSearchedEstates(searchCriteria));
		model.addAttribute("estates", estateService.listCriteria(searchCriteria));
		model.addAttribute("estates", estateService.listSearch(searchCriteria));
		model.addAttribute("pageMaker", pageMaker);
		return "board/estate/list";
	}

	@RequestMapping(value = "/listCriteria", method = RequestMethod.GET)
	public String listCriteria(Model model, Criteria criteria) throws Exception {
		logger.info("listCriteria ...");
		model.addAttribute("estates", estateService.listCriteria(criteria));
		return "/board/estate/list_criteria";
	}

	// 조화 페이지
	@RequestMapping(value = "/read", method = RequestMethod.GET)

	public String read(@RequestParam("data_no") int data_no,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search read() called...");
		model.addAttribute("estate", estateService.read(data_no));
		return "board/estate/read";
	}

	// 수정 페이지

	@RequestMapping(value = "/modify", method = RequestMethod.GET)

	public String modifyGET(@RequestParam("data_no") int data_no,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search modifyGet()called ...");
		logger.info(searchCriteria.toString());
		model.addAttribute("estate", estateService.read(data_no));
		return "board/estate/modify";
	}

	// 수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(EstateVo estateVo, SearchCriteria searchCriteria, RedirectAttributes redirectAttributes)
			throws Exception {
		logger.info("search modifyPOST() called ...");
		estateService.update(estateVo);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
		redirectAttributes.addFlashAttribute("msg", "modSuccess");
		return "redirect:/board/estate/list";
	}
	// 삭제 처리

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("data_no") int data_no, SearchCriteria searchCriteria,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.info("search remove() called ...");
		estateService.delete(data_no);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
		redirectAttributes.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/estate/list";

	}
}