package com.sesac.finewiki.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.persistence.EstateDAO;
import com.sesac.finewiki.persistence.EstateReplyDAO;
import com.sesac.finewiki.vo.EstateReplyVo;

@Service
public class EstateReplyServiceImpl implements EstateReplyService {
	private final EstateReplyDAO estateReplyDAO;
	private final EstateDAO estateDAO;

	@Inject
	public EstateReplyServiceImpl(EstateReplyDAO estateReplyDAO, EstateDAO estateDAO) {
		this.estateReplyDAO = estateReplyDAO;
		this.estateDAO = estateDAO;
	}

	// 댓글 등록
	@Transactional // 트랜잭션 처리
	@Override
	public void addReply(EstateReplyVo estateReplyVo) throws Exception {
		estateReplyDAO.create(estateReplyVo); // 댓글 등록
		estateDAO.updateReplyCnt(estateReplyVo.getData_no(), 1); // 댓글 갯수 증가

	}

	// 댓글 삭제
	@Transactional // 트랜잭션 처리
	@Override
	public void removeReply(Integer reply_no) throws Exception {
		int data_no = estateReplyDAO.getData_no(reply_no); // 댓글의 게시물 번호 조회
		estateReplyDAO.delete(reply_no); // 댓글 삭제
		estateDAO.updateReplyCnt(data_no, -1); // 댓글 갯수 감소 }
	}

	@Override
	public List<EstateReplyVo> list(Integer data_no) throws Exception {
		return estateReplyDAO.list(data_no);
	}

	@Override
	public void create(EstateReplyVo estateReplyVo) throws Exception {
		estateReplyDAO.create(estateReplyVo);
	}

	@Override
	public void update(EstateReplyVo estateReplyVo) throws Exception {
		estateReplyDAO.update(estateReplyVo);
	}

	@Override
	public void delete(Integer reply_no) throws Exception {
		estateReplyDAO.delete(reply_no);
	}

	@Override
	public List<EstateReplyVo> getEstateRepliesPaging(Integer data_no, Criteria criteria) throws Exception {
		return estateReplyDAO.listPaging(data_no, criteria);
	}

	@Override
	public int countEstateReplies(Integer data_no) throws Exception {
		return estateReplyDAO.countEstateReplies(data_no);
	}

	@Override
	public List<EstateReplyVo> memberEstateReplies(String nick) throws Exception {
		return estateReplyDAO.memberEstateReplies(nick);
	}

}
