package com.sesac.finewiki.controller;


import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sesac.finewiki.service.EstateDashBoardService;

@Controller
@RequestMapping("/dashboard")
public class EstateDashBoardController {
	private static final Logger logger = LoggerFactory.getLogger(EstateDashBoardController.class);
	private final EstateDashBoardService estateDashBoardService;

	@Inject
	public EstateDashBoardController(EstateDashBoardService estateDashBoardService) {
		this.estateDashBoardService = estateDashBoardService;
	}
	@RequestMapping(value = "/estate", method = RequestMethod.GET)
	public String ss() {
		
		return "dashboard/estate";
	}
}