package com.sesac.finewiki.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.FreeReplyVo;

@Repository
public class FreeReplyDAOImpl implements FreeReplyDAO {
	private static String NAMESPACE = "com.sesac.finewiki.mappers.reply.freereplyMapper";
	private final SqlSession sqlSession;

	@Inject
	public FreeReplyDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<FreeReplyVo> list(Integer data_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".list", data_no);
	}

	@Override
	public void create(FreeReplyVo freeReplyVo) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", freeReplyVo);
	}

	@Override
	public void update(FreeReplyVo freeReplyVo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", freeReplyVo);
	}

	@Override
	public void delete(Integer reply_no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", reply_no);
	}

	@Override
	public List<FreeReplyVo> listPaging(Integer data_no, Criteria criteria) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("data_no", data_no);
		paramMap.put("criteria", criteria);
		return sqlSession.selectList(NAMESPACE + ".listPaging", paramMap);
	}

	@Override
	public int countFreeReplies(Integer data_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countFreeReplies", data_no);
	}

	@Override
	public int getData_no(Integer reply_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getData_no", reply_no);
	}

	@Override
	public List<FreeReplyVo> memberFreeReplies(String nick) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".memberFreeReplies", nick);
	}

}
