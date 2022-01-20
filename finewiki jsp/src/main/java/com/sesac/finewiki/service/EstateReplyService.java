package com.sesac.finewiki.service;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.EstateReplyVo;

public interface EstateReplyService {
	List<EstateReplyVo> list(Integer data_no) throws Exception;

	void create(EstateReplyVo estateReplyVo) throws Exception;

	void update(EstateReplyVo estateReplyVo) throws Exception;

	void delete(Integer reply_no) throws Exception;

	List<EstateReplyVo> getEstateRepliesPaging(Integer data_no, Criteria criteria) throws Exception;

	int countEstateReplies(Integer data_no) throws Exception;
	
	void removeReply(Integer reply_no)throws Exception;

	void addReply(EstateReplyVo EstateReplyVo) throws Exception;
	
	// 회원이 작성한 댓글 목록
	List<EstateReplyVo> memberEstateReplies(String nick) throws Exception;

}
