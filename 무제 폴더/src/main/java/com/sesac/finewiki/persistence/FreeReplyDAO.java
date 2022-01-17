package com.sesac.finewiki.persistence;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.FreeReplyVo;

public interface FreeReplyDAO {
	List<FreeReplyVo> list(Integer data_no) throws Exception;

	void create(FreeReplyVo freeRelyVo) throws Exception;

	void update(FreeReplyVo freeRelyVo) throws Exception;

	void delete(Integer reply_no) throws Exception;

	List<FreeReplyVo> listPaging(Integer data_no, Criteria criteria) throws Exception;

	int countFreeReplies(Integer data_no) throws Exception;

	int getData_no(Integer reply_no) throws Exception;

	// 회원이 작성한 댓글 목록
	List<FreeReplyVo> memberFreeReplies(String nick) throws Exception;
}
