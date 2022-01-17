package com.sesac.finewiki.service;

import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.persistence.BoardDAO;
import com.sesac.finewiki.persistence.BoardFileDAO;
import com.sesac.finewiki.vo.BoardVo;

@Service
public class StockDashBoardServiceImpl implements StockDashBoardService {

	private static final Logger logger = LoggerFactory.getLogger(StockDashBoardServiceImpl.class);

	private final BoardDAO boardDAO;
	private BoardFileDAO boardFileDAO;

	@Inject
	public StockDashBoardServiceImpl(BoardDAO vo) {
		this.boardDAO = vo;
	}

}
