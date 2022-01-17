package com.sesac.finewiki.service;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.FreeReplyVo;

public interface FreeReplyService {
	List<FreeReplyVo> list(Integer data_no) throws Exception;

	void create(FreeReplyVo freeReplyVo) throws Exception;

	void update(FreeReplyVo freeReplyVo) throws Exception;

	void delete(Integer reply_no) throws Exception;

	List<FreeReplyVo> getFreeRepliesPaging(Integer data_no, Criteria criteria) throws Exception;

	int countFreeReplies(Integer data_no) throws Exception;
	
	void removeReply(Integer reply_no)throws Exception;

	void addReply(FreeReplyVo freeReplyVo) throws Exception;
	
	// 회원이 작성한 댓글 목록
	List<FreeReplyVo> memberFreeReplies(String nick) throws Exception;

}
