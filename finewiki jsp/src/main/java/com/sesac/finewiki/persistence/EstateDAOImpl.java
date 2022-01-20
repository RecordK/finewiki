package com.sesac.finewiki.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.EstateVo;

@Repository
public class EstateDAOImpl implements EstateDAO {

	private static final String NAMESPACE = "com.sesac.finewiki.mappers.board.estate.estateMapper";

	private final SqlSession sqlSession;

	@Inject
	public EstateDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void create(EstateVo estateVo) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", estateVo);
	}

	@Override
	public EstateVo read(Integer data_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", data_no);
	}

	@Override
	public void update(EstateVo estateVo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", estateVo);
	}

	@Override
	public void delete(Integer data_no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", data_no);
	}

	@Override
	public List<EstateVo> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<EstateVo> listPaging(int page) throws Exception {

		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;

		return sqlSession.selectList(NAMESPACE + ".listPaging", page);

	}

	@Override
	public List<EstateVo> listCriteria(Criteria criteria) throws Exception {

		return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
	}

	@Override
	public int countEstates(Criteria criteria) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countEstates", criteria);
	}

	@Override
	public List<EstateVo> listSearch(SearchCriteria searchCriteria) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", searchCriteria);
	}

	@Override
	public int countSearchedEstates(SearchCriteria searchCriteria) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countSearchedEstates", searchCriteria);
	}

	@Override
	public void updateReplyCnt(Integer data_no, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("data_no", data_no);
		paramMap.put("amount", amount);
		sqlSession.update(NAMESPACE + ".updateReplyCnt", paramMap);
	}

	@Override
	public void updateHit(Integer data_no) throws Exception {
		sqlSession.update(NAMESPACE + ".updateHit", data_no);
	}

	@Override
	public List<EstateVo> memberEstateList(String mem_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".memberEstateList", mem_id);
	}

	@Override
	public void updateMemberImg(EstateVo estateVo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateMemberImg", estateVo);
	}
}
