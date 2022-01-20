package com.sesac.finewiki.persistence;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.ReplyVo;

public interface ReplyDAO {
	List<ReplyVo> list(Integer article_no) throws Exception;

	void create(ReplyVo replyVO) throws Exception;

	void update(ReplyVo replyVO) throws Exception;

	void delete(Integer reply_no) throws Exception;

	List<ReplyVo> listPaging(Integer data_no, Criteria criteria) throws Exception;

	int countReplies(Integer data_no) throws Exception;

	int getData_no(Integer reply_no) throws Exception;

	// 회원이 작성한 댓글 목록
	List<ReplyVo> memberReplies(String mem_id) throws Exception;
}
