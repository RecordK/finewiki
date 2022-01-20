package com.sesac.finewiki.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sesac.finewiki.persistence.BoardDAO;
import com.sesac.finewiki.persistence.BoardFileDAO;

@Service
public class FreeDashBoardServiceImpl implements FreeDashBoardService {

	private static final Logger logger = LoggerFactory.getLogger(FreeDashBoardServiceImpl.class);

	private final BoardDAO boardDAO;
	private BoardFileDAO boardFileDAO;

	@Inject
	public FreeDashBoardServiceImpl(BoardDAO vo) {
		this.boardDAO = vo;
	}

}
