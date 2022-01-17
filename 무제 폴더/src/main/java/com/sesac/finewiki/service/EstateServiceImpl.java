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
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.EstateVo;

@Service
public class EstateServiceImpl implements EstateService {

	private static final Logger logger = LoggerFactory.getLogger(EstateServiceImpl.class);

	private final EstateDAO estateDAO;
	private BoardFileDAO boardFileDAO;

	@Inject
	public EstateServiceImpl(EstateDAO estateDAO) {
		this.estateDAO = estateDAO;
	}

	@Transactional
	@Override
	public void create(EstateVo vo) throws Exception {
		estateDAO.create(vo);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public EstateVo read(Integer data_no) throws Exception {
		estateDAO.updateHit(data_no);
		return estateDAO.read(data_no);
	}

	@Transactional
	@Override
	public void update(EstateVo vo) throws Exception {
		estateDAO.update(vo);
	}

	@Transactional
	@Override
	public void delete(Integer data_no) throws Exception {
		estateDAO.delete(data_no);
	}

	@Override
	public List<EstateVo> listAll() throws Exception {
		return estateDAO.listAll();
	}

	@Override
	public List<EstateVo> listCriteria(Criteria criteria) throws Exception {
		return estateDAO.listCriteria(criteria);
	}

	@Override
	public int countEstates(Criteria criteria) throws Exception {
		return estateDAO.countEstates(criteria);
	}

	@Override
	public List<EstateVo> listSearch(SearchCriteria searchCriteria) throws Exception {
		return estateDAO.listSearch(searchCriteria);
	}

	@Override
	public int countSearchedEstates(SearchCriteria searchCriteria) throws Exception {
		return estateDAO.countSearchedEstates(searchCriteria);
	}

	@Override
	public List<EstateVo> memberEstateList(String mem_id) throws Exception {
		return estateDAO.memberEstateList(mem_id);
	}

}
