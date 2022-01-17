package com.sesac.finewiki.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.StockReplyVo;

@Repository
public class StockReplyDAOImpl implements StockReplyDAO {
	private static String NAMESPACE = "com.sesac.finewiki.mappers.reply.stockreplyMapper";
	private final SqlSession sqlSession;

	@Inject
	public StockReplyDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<StockReplyVo> list(Integer data_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".list", data_no);
	}

	@Override
	public void create(StockReplyVo stockReplyVo) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", stockReplyVo);
	}

	@Override
	public void update(StockReplyVo stockReplyVo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", stockReplyVo);
	}

	@Override
	public void delete(Integer reply_no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", reply_no);
	}

	@Override
	public List<StockReplyVo> listPaging(Integer data_no, Criteria criteria) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("data_no", data_no);
		paramMap.put("criteria", criteria);
		return sqlSession.selectList(NAMESPACE + ".listPaging", paramMap);
	}

	@Override
	public int countStockReplies(Integer data_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countStockReplies", data_no);
	}

	@Override
	public int getData_no(Integer reply_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getData_no", reply_no);
	}

	@Override
	public List<StockReplyVo> memberStockReplies(String nick) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".memberStockReplies", nick);
	}

}
