package com.sesac.finewiki.service;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;

public interface BoardService {
	void create(BoardVo vo) throws Exception;

	BoardVo read(Integer data_no) throws Exception;

	void update(BoardVo boardVo) throws Exception;

	void delete(Integer data_no) throws Exception;

	List<BoardVo> listAll() throws Exception;

	List<BoardVo> listCriteria(Criteria criteria) throws Exception;

	int countBoards(Criteria criteria) throws Exception;

	List<BoardVo> listSearch(SearchCriteria searchCriteria) throws Exception;

	int countSearchedBoards(SearchCriteria searchCriteria) throws Exception;
	
	List<BoardVo> memberBoardList(String mem_id) throws Exception;

}
