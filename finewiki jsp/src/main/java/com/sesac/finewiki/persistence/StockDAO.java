package com.sesac.finewiki.persistence;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.StockVo;

public interface StockDAO {

	void create(StockVo stockVo) throws Exception;

	StockVo read(Integer data_no) throws Exception;

	void update(StockVo stockVo) throws Exception;

	void delete(Integer data_no) throws Exception;

	List<StockVo> listAll() throws Exception;

	List<StockVo> listPaging(int page) throws Exception;

	List<StockVo> listCriteria(Criteria criteria) throws Exception;

	int countStocks(Criteria criteria) throws Exception;

	List<StockVo> listSearch(SearchCriteria searchCriteria) throws Exception;

	int countSearchedStocks(SearchCriteria searchCriteria) throws Exception;

	void updateReplyCnt(Integer data_no, int amount) throws Exception;
	
	void updateHit(Integer data_no) throws Exception;


	// 회원이 작성한 게시글 목록
	List<StockVo> memberStockList(String mem_id) throws Exception;

	// 회원 프로필 사진 수정
	void updateMemberImg(StockVo stockVo) throws Exception;

}
