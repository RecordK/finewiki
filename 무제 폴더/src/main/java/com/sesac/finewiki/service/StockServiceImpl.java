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
import com.sesac.finewiki.persistence.StockDAO;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.StockVo;

@Service
public class StockServiceImpl implements StockService {

	private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

	private final StockDAO stockDAO;
	private BoardFileDAO boardFileDAO;

	@Inject
	public StockServiceImpl(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	@Transactional
	@Override
	public void create(StockVo stockVo) throws Exception {
		stockDAO.create(stockVo);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public StockVo read(Integer data_no) throws Exception {
		stockDAO.updateHit(data_no);
		return stockDAO.read(data_no);
	}

	@Transactional
	@Override
	public void update(StockVo StockVo) throws Exception {
		stockDAO.update(StockVo);
	}

	@Transactional
	@Override
	public void delete(Integer data_no) throws Exception {
		stockDAO.delete(data_no);
	}

	@Override
	public List<StockVo> listAll() throws Exception {
		return stockDAO.listAll();
	}

	@Override
	public List<StockVo> listCriteria(Criteria criteria) throws Exception {
		return stockDAO.listCriteria(criteria);
	}

	@Override
	public int countStocks(Criteria criteria) throws Exception {
		return stockDAO.countStocks(criteria);
	}

	@Override
	public List<StockVo> listSearch(SearchCriteria searchCriteria) throws Exception {
		return stockDAO.listSearch(searchCriteria);
	}

	@Override
	public int countSearchedStocks(SearchCriteria searchCriteria) throws Exception {
		return stockDAO.countSearchedStocks(searchCriteria);
	}

	@Override
	public List<StockVo> memberStockList(String mem_id) throws Exception {
		return stockDAO.memberStockList(mem_id);
	}

}
