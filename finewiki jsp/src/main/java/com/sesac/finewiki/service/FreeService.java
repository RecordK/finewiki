package com.sesac.finewiki.service;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.FreeVo;

public interface FreeService {
	void create(FreeVo freeVo) throws Exception;

	FreeVo read(Integer data_no) throws Exception;

	void update(FreeVo freeVo) throws Exception;

	void delete(Integer data_no) throws Exception;

	List<FreeVo> listAll() throws Exception;

	List<FreeVo> listCriteria(Criteria criteria) throws Exception;

	int countFrees(Criteria criteria) throws Exception;

	List<FreeVo> listSearch(SearchCriteria searchCriteria) throws Exception;

	int countSearchedFrees(SearchCriteria searchCriteria) throws Exception;
	
	List<FreeVo> memberFreeList(String mem_id) throws Exception;

}
