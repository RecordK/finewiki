package com.sesac.finewiki.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
import com.sesac.finewiki.service.StockDashBoardService;

@Controller
@RequestMapping("/dashboard")
public class StockDashBoardController {
	private static final Logger logger = LoggerFactory.getLogger(StockDashBoardController.class);
	private final StockDashBoardService stockDashBoardService;

	@Inject
	public StockDashBoardController(StockDashBoardService stockDashBoardService) {
		this.stockDashBoardService = stockDashBoardService;
	}
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public String ss() {
		
		return "dashboard/stock";
	}
}