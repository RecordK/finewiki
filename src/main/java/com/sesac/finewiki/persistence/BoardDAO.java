package com.sesac.finewiki.persistence;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;

public interface BoardDAO {

	void create(BoardVo boardVo) throws Exception;

	BoardVo read(Integer data_no) throws Exception;

	void update(BoardVo boardVo) throws Exception;

	void delete(Integer data_no) throws Exception;

	List<BoardVo> listAll() throws Exception;

	List<BoardVo> listPaging(int page) throws Exception;

	List<BoardVo> listCriteria(Criteria criteria) throws Exception;

	int countBoards(Criteria criteria) throws Exception;

	List<BoardVo> listSearch(SearchCriteria searchCriteria) throws Exception;

	int countSearchedBoards(SearchCriteria searchCriteria) throws Exception;

	void updateReplyCnt(Integer data_no, int amount) throws Exception;
	
	void updateHit(Integer data_no) throws Exception;


	// 회원이 작성한 게시글 목록
	List<BoardVo> memberBoardList(String mem_id) throws Exception;

	// 회원 프로필 사진 수정
	void updateMemberImg(BoardVo boardVo) throws Exception;

}
