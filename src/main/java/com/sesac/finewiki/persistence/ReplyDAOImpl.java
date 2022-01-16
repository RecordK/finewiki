package com.sesac.finewiki.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.ReplyVo;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	private static String NAMESPACE = "com.sesac.finewiki.mappers.reply.replyMapper";
	private final SqlSession sqlSession;

	@Inject
	public ReplyDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ReplyVo> list(Integer data_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".list", data_no);
	}

	@Override
	public void create(ReplyVo replyVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", replyVO);
	}

	@Override
	public void update(ReplyVo replyVO) throws Exception {
		sqlSession.update(NAMESPACE + ".update", replyVO);
	}

	@Override
	public void delete(Integer reply_no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", reply_no);
	}

	@Override
	public List<ReplyVo> listPaging(Integer data_no, Criteria criteria) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("data_no", data_no);
		paramMap.put("criteria", criteria);
		return sqlSession.selectList(NAMESPACE + ".listPaging", paramMap);
	}

	@Override
	public int countReplies(Integer data_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countReplies", data_no);
	}

	@Override
	public int getData_no(Integer reply_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getData_no", reply_no);
	}

	@Override
	public List<ReplyVo> memberReplies(String mem_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".memberReplies", mem_id);
	}

}
