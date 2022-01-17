package com.sesac.finewiki.service;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.StockReplyVo;

public interface StockReplyService {
	List<StockReplyVo> list(Integer data_no) throws Exception;

	void create(StockReplyVo stockReplyVo) throws Exception;

	void update(StockReplyVo stockReplyVo) throws Exception;

	void delete(Integer reply_no) throws Exception;

	List<StockReplyVo> getStockRepliesPaging(Integer data_no, Criteria criteria) throws Exception;

	int countStockReplies(Integer data_no) throws Exception;
	
	void removeReply(Integer reply_no)throws Exception;

	void addReply(StockReplyVo stockReplyVo) throws Exception;
	
	// 회원이 작성한 댓글 목록
	List<StockReplyVo> memberStockReplies(String nick) throws Exception;

}
