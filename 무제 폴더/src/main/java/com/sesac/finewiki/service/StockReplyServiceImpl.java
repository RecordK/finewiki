package com.sesac.finewiki.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.persistence.StockDAO;
import com.sesac.finewiki.persistence.StockReplyDAO;
import com.sesac.finewiki.vo.StockReplyVo;

@Service
public class StockReplyServiceImpl implements StockReplyService {
	private final StockReplyDAO stockReplyDAO;
	private final StockDAO stockDAO;

	@Inject
	public StockReplyServiceImpl(StockReplyDAO stockReplyDAO, StockDAO stockDAO) {
		this.stockReplyDAO = stockReplyDAO;
		this.stockDAO = stockDAO;
	}

	// 댓글 등록
	@Transactional // 트랜잭션 처리
	@Override
	public void addReply(StockReplyVo stockReplyVo) throws Exception {
		stockReplyDAO.create(stockReplyVo); // 댓글 등록
		stockDAO.updateReplyCnt(stockReplyVo.getData_no(), 1); // 댓글 갯수 증가

	}

	// 댓글 삭제
	@Transactional // 트랜잭션 처리
	@Override
	public void removeReply(Integer reply_no) throws Exception {
		int data_no = stockReplyDAO.getData_no(reply_no); // 댓글의 게시물 번호 조회
		stockReplyDAO.delete(reply_no); // 댓글 삭제
		stockDAO.updateReplyCnt(data_no, -1); // 댓글 갯수 감소 }
	}

	@Override
	public List<StockReplyVo> list(Integer data_no) throws Exception {
		return stockReplyDAO.list(data_no);
	}

	@Override
	public void create(StockReplyVo stockReplyVo) throws Exception {
		stockReplyDAO.create(stockReplyVo);
	}

	@Override
	public void update(StockReplyVo stockReplyVo) throws Exception {
		stockReplyDAO.update(stockReplyVo);
	}

	@Override
	public void delete(Integer reply_no) throws Exception {
		stockReplyDAO.delete(reply_no);
	}

	@Override
	public List<StockReplyVo> getStockRepliesPaging(Integer data_no, Criteria criteria) throws Exception {
		return stockReplyDAO.listPaging(data_no, criteria);
	}

	@Override
	public int countStockReplies(Integer data_no) throws Exception {
		return stockReplyDAO.countStockReplies(data_no);
	}

	@Override
	public List<StockReplyVo> memberStockReplies(String nick) throws Exception {
		return stockReplyDAO.memberStockReplies(nick);
	}

}
