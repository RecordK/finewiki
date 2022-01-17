package com.sesac.finewiki.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.persistence.FreeDAO;
import com.sesac.finewiki.persistence.FreeReplyDAO;
import com.sesac.finewiki.vo.FreeReplyVo;

@Service
public class FreeReplyServiceImpl implements FreeReplyService {
	private final FreeReplyDAO freeReplyDAO;
	private final FreeDAO freeDAO;

	@Inject
	public FreeReplyServiceImpl(FreeReplyDAO freeReplyDAO, FreeDAO freeDAO) {
		this.freeReplyDAO = freeReplyDAO;
		this.freeDAO = freeDAO;
	}

	// 댓글 등록
	@Transactional // 트랜잭션 처리
	@Override
	public void addReply(FreeReplyVo freeReplyVo) throws Exception {
		freeReplyDAO.create(freeReplyVo); // 댓글 등록
		freeDAO.updateReplyCnt(freeReplyVo.getData_no(), 1); // 댓글 갯수 증가

	}

	// 댓글 삭제
	@Transactional // 트랜잭션 처리
	@Override
	public void removeReply(Integer reply_no) throws Exception {
		int data_no = freeReplyDAO.getData_no(reply_no); // 댓글의 게시물 번호 조회
		freeReplyDAO.delete(reply_no); // 댓글 삭제
		freeDAO.updateReplyCnt(data_no, -1); // 댓글 갯수 감소 }
	}

	@Override
	public List<FreeReplyVo> list(Integer data_no) throws Exception {
		return freeReplyDAO.list(data_no);
	}

	@Override
	public void create(FreeReplyVo freeReplyVo) throws Exception {
		freeReplyDAO.create(freeReplyVo);
	}

	@Override
	public void update(FreeReplyVo freeReplyVo) throws Exception {
		freeReplyDAO.update(freeReplyVo);
	}

	@Override
	public void delete(Integer reply_no) throws Exception {
		freeReplyDAO.delete(reply_no);
	}

	@Override
	public List<FreeReplyVo> getFreeRepliesPaging(Integer data_no, Criteria criteria) throws Exception {
		return freeReplyDAO.listPaging(data_no, criteria);
	}

	@Override
	public int countFreeReplies(Integer data_no) throws Exception {
		return freeReplyDAO.countFreeReplies(data_no);
	}

	@Override
	public List<FreeReplyVo> memberFreeReplies(String nick) throws Exception {
		return freeReplyDAO.memberFreeReplies(nick);
	}

}
