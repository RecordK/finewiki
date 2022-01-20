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
import com.sesac.finewiki.vo.FreeVo;

@Repository
public class FreeDAOImpl implements FreeDAO {

	private static final String NAMESPACE = "com.sesac.finewiki.mappers.board.free.freeMapper";

	private final SqlSession sqlSession;

	@Inject
	public FreeDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void create(FreeVo freeVo) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", freeVo);
	}

	@Override
	public FreeVo read(Integer data_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", data_no);
	}

	@Override
	public void update(FreeVo freeVo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", freeVo);
	}

	@Override
	public void delete(Integer data_no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", data_no);
	}

	@Override
	public List<FreeVo> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<FreeVo> listPaging(int page) throws Exception {

		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;

		return sqlSession.selectList(NAMESPACE + ".listPaging", page);

	}

	@Override
	public List<FreeVo> listCriteria(Criteria criteria) throws Exception {

		return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
	}

	@Override
	public int countFrees(Criteria criteria) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countFrees", criteria);
	}

	@Override
	public List<FreeVo> listSearch(SearchCriteria searchCriteria) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", searchCriteria);
	}

	@Override
	public int countSearchedFrees(SearchCriteria searchCriteria) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countSearchedFrees", searchCriteria);
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
	public List<FreeVo> memberFreeList(String mem_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".memberFreeList", mem_id);
	}

	@Override
	public void updateMemberImg(FreeVo freeVo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateMemberImg", freeVo);
	}
}
