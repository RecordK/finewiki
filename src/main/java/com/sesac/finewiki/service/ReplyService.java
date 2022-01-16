package com.sesac.finewiki.service;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.ReplyVo;

public interface ReplyService {
	List<ReplyVo> list(Integer data_no) throws Exception;

	void create(ReplyVo vo) throws Exception;

	void update(ReplyVo vo) throws Exception;

	void delete(Integer reply_no) throws Exception;

	List<ReplyVo> getRepliesPaging(Integer data_no, Criteria criteria) throws Exception;

	int countReplies(Integer data_no) throws Exception;
	
	void removeReply(Integer reply_no)throws Exception;

	void addReply(ReplyVo replyVo) throws Exception;
	
	// 회원이 작성한 댓글 목록
	List<ReplyVo> memberReplies(String mem_id) throws Exception;

}
