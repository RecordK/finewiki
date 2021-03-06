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
import com.sesac.finewiki.vo.StockVo;
import com.sesac.finewiki.service.StockDashBoardService;
import com.sesac.finewiki.service.StockService;

@Controller
@RequestMapping("/board/stock")
public class StockBoardController {
	private static final Logger logger = LoggerFactory.getLogger(StockBoardController.class);
	private final StockService stockService;

	@Inject
	public StockBoardController(StockService stockService) {
		this.stockService = stockService;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {
		logger.info("search writeGET() called...");
		return "board/stock/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(StockVo stockVo, RedirectAttributes redirectAttributes) throws Exception {
		logger.info("search writePOST() called...");
		stockService.create(stockVo);
		redirectAttributes.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/stock/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search list() called ...");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(searchCriteria);
		pageMaker.setTotalCount(stockService.countStocks(searchCriteria));
		pageMaker.setTotalCount(stockService.countSearchedStocks(searchCriteria));
		model.addAttribute("stocks", stockService.listCriteria(searchCriteria));
		model.addAttribute("stocks", stockService.listSearch(searchCriteria));
		model.addAttribute("pageMaker", pageMaker);
		return "board/stock/list";
	}

	@RequestMapping(value = "/listCriteria", method = RequestMethod.GET)
	public String listCriteria(Model model, Criteria criteria) throws Exception {
		logger.info("listCriteria ...");
		model.addAttribute("stocks", stockService.listCriteria(criteria));
		return "/board/stock/list_criteria";
	}

	// ?????? ?????????
	@RequestMapping(value = "/read", method = RequestMethod.GET)

	public String read(@RequestParam("data_no") int data_no,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search read() called...");
		model.addAttribute("stock", stockService.read(data_no));
		return "board/stock/read";
	}

	// ?????? ?????????

	@RequestMapping(value = "/modify", method = RequestMethod.GET)

	public String modifyGET(@RequestParam("data_no") int data_no,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search modifyGet()called ...");
		logger.info(searchCriteria.toString());
		model.addAttribute("stock", stockService.read(data_no));
		return "board/stock/modify";
	}

	// ?????? ??????
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(StockVo stockVo, SearchCriteria searchCriteria, RedirectAttributes redirectAttributes)
			throws Exception {
		logger.info("search modifyPOST() called ...");
		stockService.update(stockVo);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
		redirectAttributes.addFlashAttribute("msg", "modSuccess");
		return "redirect:/board/stock/list";
	}
	// ?????? ??????

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("data_no") int data_no, SearchCriteria searchCriteria,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.info("search remove() called ...");
		stockService.delete(data_no);
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
		redirectAttributes.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/stock/list";

	}
}