package com.sesac.finewiki.service;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.StockVo;

public interface StockService {
	void create(StockVo stockVo) throws Exception;

	StockVo read(Integer data_no) throws Exception;

	void update(StockVo boardVo) throws Exception;

	void delete(Integer data_no) throws Exception;

	List<StockVo> listAll() throws Exception;

	List<StockVo> listCriteria(Criteria criteria) throws Exception;

	int countStocks(Criteria criteria) throws Exception;

	List<StockVo> listSearch(SearchCriteria searchCriteria) throws Exception;

	int countSearchedStocks(SearchCriteria searchCriteria) throws Exception;
	
	List<StockVo> memberStockList(String mem_id) throws Exception;

}
