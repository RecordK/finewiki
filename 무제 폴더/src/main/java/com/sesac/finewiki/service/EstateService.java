package com.sesac.finewiki.service;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.EstateVo;

public interface EstateService {
	void create(EstateVo vo) throws Exception;

	EstateVo read(Integer data_no) throws Exception;

	void update(EstateVo vo) throws Exception;

	void delete(Integer data_no) throws Exception;

	List<EstateVo> listAll() throws Exception;

	List<EstateVo> listCriteria(Criteria criteria) throws Exception;

	int countEstates(Criteria criteria) throws Exception;

	List<EstateVo> listSearch(SearchCriteria searchCriteria) throws Exception;

	int countSearchedEstates(SearchCriteria searchCriteria) throws Exception;
	
	List<EstateVo> memberEstateList(String mem_id) throws Exception;

}
