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
import com.sesac.finewiki.persistence.EstateDAO;
import com.sesac.finewiki.persistence.FreeDAO;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.EstateVo;
import com.sesac.finewiki.vo.FreeVo;

@Service
public class FreeServiceImpl implements FreeService {

	private static final Logger logger = LoggerFactory.getLogger(FreeServiceImpl.class);

	private final FreeDAO freeDAO;
	private BoardFileDAO boardFileDAO;

	@Inject
	public FreeServiceImpl(FreeDAO freeDAO) {
		this.freeDAO = freeDAO;
	}

	@Transactional
	@Override
	public void create(FreeVo freeVo) throws Exception {
		freeDAO.create(freeVo);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public FreeVo read(Integer data_no) throws Exception {
		freeDAO.updateHit(data_no);
		return freeDAO.read(data_no);
	}

	@Transactional
	@Override
	public void update(FreeVo freeVo) throws Exception {
		freeDAO.update(freeVo);
	}

	@Transactional
	@Override
	public void delete(Integer data_no) throws Exception {
		freeDAO.delete(data_no);
	}

	@Override
	public List<FreeVo> listAll() throws Exception {
		return freeDAO.listAll();
	}

	@Override
	public List<FreeVo> listCriteria(Criteria criteria) throws Exception {
		return freeDAO.listCriteria(criteria);
	}

	@Override
	public int countFrees(Criteria criteria) throws Exception {
		return freeDAO.countFrees(criteria);
	}

	@Override
	public List<FreeVo> listSearch(SearchCriteria searchCriteria) throws Exception {
		return freeDAO.listSearch(searchCriteria);
	}

	@Override
	public int countSearchedFrees(SearchCriteria searchCriteria) throws Exception {
		return freeDAO.countSearchedFrees(searchCriteria);
	}

	@Override
	public List<FreeVo> memberFreeList(String mem_id) throws Exception {
		return freeDAO.memberFreeList(mem_id);
	}

}
