package com.sesac.finewiki.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sesac.finewiki.service.EstateDashBoardService;
import com.sesac.finewiki.service.FreeDashBoardService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class FreeDashBoardController {
	private static final Logger logger = LoggerFactory.getLogger(FreeDashBoardController.class);
	private final FreeDashBoardService freeDashBoardService;

	@Inject
	public FreeDashBoardController(FreeDashBoardService freeDashBoardService) {
		this.freeDashBoardService = freeDashBoardService;
	}
	@RequestMapping(value = "/free", method = RequestMethod.GET)
	public String ss() {
		
		return "dashboard/free";
	}
}