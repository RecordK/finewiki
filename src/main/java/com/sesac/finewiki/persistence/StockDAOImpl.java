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
import com.sesac.finewiki.vo.StockVo;

@Repository
public class StockDAOImpl implements StockDAO {

	private static final String NAMESPACE = "com.sesac.finewiki.mappers.board.stock.stockMapper";

	private final SqlSession sqlSession;

	@Inject
	public StockDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void create(StockVo stockVo) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", stockVo);
	}

	@Override
	public StockVo read(Integer data_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", data_no);
	}

	@Override
	public void update(StockVo stockVo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", stockVo);
	}

	@Override
	public void delete(Integer data_no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", data_no);
	}

	@Override
	public List<StockVo> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<StockVo> listPaging(int page) throws Exception {

		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;

		return sqlSession.selectList(NAMESPACE + ".listPaging", page);

	}

	@Override
	public List<StockVo> listCriteria(Criteria criteria) throws Exception {

		return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
	}

	@Override
	public int countStocks(Criteria criteria) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countStocks", criteria);
	}

	@Override
	public List<StockVo> listSearch(SearchCriteria searchCriteria) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", searchCriteria);
	}

	@Override
	public int countSearchedStocks(SearchCriteria searchCriteria) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countSearchedStocks", searchCriteria);
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
	public List<StockVo> memberStockList(String mem_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".memberStockList", mem_id);
	}

	@Override
	public void updateMemberImg(StockVo stockVo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateMemberImg", stockVo);
	}
}
