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

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final String NAMESPACE = "com.sesac.finewiki.mappers.board.boardMapper";

	private final SqlSession sqlSession;

	@Inject
	public BoardDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void create(BoardVo boardVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", boardVO);
	}

	@Override
	public BoardVo read(Integer data_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", data_no);
	}

	@Override
	public void update(BoardVo boardVO) throws Exception {
		sqlSession.update(NAMESPACE + ".update", boardVO);
	}

	@Override
	public void delete(Integer data_no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", data_no);
	}

	@Override
	public List<BoardVo> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<BoardVo> listPaging(int page) throws Exception {

		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;

		return sqlSession.selectList(NAMESPACE + ".listPaging", page);

	}

	@Override
	public List<BoardVo> listCriteria(Criteria criteria) throws Exception {

		return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
	}

	@Override
	public int countBoards(Criteria criteria) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countBoards", criteria);
	}

	@Override
	public List<BoardVo> listSearch(SearchCriteria searchCriteria) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", searchCriteria);
	}

	@Override
	public int countSearchedBoards(SearchCriteria searchCriteria) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countSearchedBoards", searchCriteria);
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
	public List<BoardVo> memberBoardList(String mem_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".memberBoardList", mem_id);
	}

	@Override
	public void updateMemberImg(BoardVo boardVo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateMemberImg", boardVo);
	}
}
