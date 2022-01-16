package com.sesac.finewiki.service;

import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.persistence.BoardDAO;
import com.sesac.finewiki.persistence.BoardFileDAO;
import com.sesac.finewiki.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	private final BoardDAO boardDAO;
	private BoardFileDAO boardFileDAO;

	@Inject
	public BoardServiceImpl(BoardDAO vo) {
		this.boardDAO = vo;
	}

	@Transactional
	@Override
	public void create(BoardVo vo) throws Exception {
		boardDAO.create(vo);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVo read(Integer data_no) throws Exception {
		boardDAO.updateHit(data_no);
		return boardDAO.read(data_no);
	}

	@Transactional
	@Override
	public void update(BoardVo vo) throws Exception {
		boardDAO.update(vo);
	}

	@Transactional
	@Override
	public void delete(Integer data_no) throws Exception {
		boardDAO.delete(data_no);
	}

	@Override
	public List<BoardVo> listAll() throws Exception {
		return boardDAO.listAll();
	}

	@Override
	public List<BoardVo> listCriteria(Criteria criteria) throws Exception {
		return boardDAO.listCriteria(criteria);
	}

	@Override
	public int countBoards(Criteria criteria) throws Exception {
		return boardDAO.countBoards(criteria);
	}

	@Override
	public List<BoardVo> listSearch(SearchCriteria searchCriteria) throws Exception {
		return boardDAO.listSearch(searchCriteria);
	}

	@Override
	public int countSearchedBoards(SearchCriteria searchCriteria) throws Exception {
		return boardDAO.countSearchedBoards(searchCriteria);
	}

	@Override
	public List<BoardVo> memberBoardList(String mem_id) throws Exception {
		return boardDAO.memberBoardList(mem_id);
	}

}
