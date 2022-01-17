package com.sesac.finewiki.persistence;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.StockReplyVo;

public interface StockReplyDAO {
	List<StockReplyVo> list(Integer data_no) throws Exception;

	void create(StockReplyVo stockReplyVo) throws Exception;

	void update(StockReplyVo stockReplyVo) throws Exception;

	void delete(Integer reply_no) throws Exception;

	List<StockReplyVo> listPaging(Integer data_no, Criteria criteria) throws Exception;

	int countStockReplies(Integer data_no) throws Exception;

	int getData_no(Integer reply_no) throws Exception;

	// 회원이 작성한 댓글 목록
	List<StockReplyVo> memberStockReplies(String nick) throws Exception;
}
