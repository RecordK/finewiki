package com.sesac.finewiki.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.persistence.BoardDAO;
import com.sesac.finewiki.persistence.ReplyDAO;
import com.sesac.finewiki.vo.ReplyVo;

@Service
public class ReplyServiceImpl implements ReplyService {
	private final ReplyDAO replyDAO;
	private final BoardDAO boardDAO;

	@Inject
	public ReplyServiceImpl(ReplyDAO replyDAO, BoardDAO boardDAO) {
		this.replyDAO = replyDAO;
		this.boardDAO = boardDAO;
	}

	// 댓글 등록
	@Transactional // 트랜잭션 처리
	@Override
	public void addReply(ReplyVo replyVo) throws Exception {
		replyDAO.create(replyVo); // 댓글 등록
		boardDAO.updateReplyCnt(replyVo.getData_no(), 1); // 댓글 갯수 증가

	}

	// 댓글 삭제
	@Transactional // 트랜잭션 처리
	@Override
	public void removeReply(Integer reply_no) throws Exception {
		int data_no = replyDAO.getData_no(reply_no); // 댓글의 게시물 번호 조회
		replyDAO.delete(reply_no); // 댓글 삭제
		boardDAO.updateReplyCnt(data_no, -1); // 댓글 갯수 감소 }
	}

	@Override
	public List<ReplyVo> list(Integer data_no) throws Exception {
		return replyDAO.list(data_no);
	}

	@Override
	public void create(ReplyVo vo) throws Exception {
		replyDAO.create(vo);
	}

	@Override
	public void update(ReplyVo vo) throws Exception {
		replyDAO.update(vo);
	}

	@Override
	public void delete(Integer reply_no) throws Exception {
		replyDAO.delete(reply_no);
	}

	@Override
	public List<ReplyVo> getRepliesPaging(Integer data_no, Criteria criteria) throws Exception {
		return replyDAO.listPaging(data_no, criteria);
	}

	@Override
	public int countReplies(Integer data_no) throws Exception {
		return replyDAO.countReplies(data_no);
	}

	@Override
	public List<ReplyVo> memberReplies(String mem_id) throws Exception {
		return replyDAO.memberReplies(mem_id);
	}


}
