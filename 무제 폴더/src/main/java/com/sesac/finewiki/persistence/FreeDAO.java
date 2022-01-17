package com.sesac.finewiki.persistence;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.FreeVo;

public interface FreeDAO {

	void create(FreeVo freeVo) throws Exception;

	FreeVo read(Integer data_no) throws Exception;

	void update(FreeVo freeVo) throws Exception;

	void delete(Integer data_no) throws Exception;

	List<FreeVo> listAll() throws Exception;

	List<FreeVo> listPaging(int page) throws Exception;

	List<FreeVo> listCriteria(Criteria criteria) throws Exception;

	int countFrees(Criteria criteria) throws Exception;

	List<FreeVo> listSearch(SearchCriteria searchCriteria) throws Exception;

	int countSearchedFrees(SearchCriteria searchCriteria) throws Exception;

	void updateReplyCnt(Integer data_no, int amount) throws Exception;
	
	void updateHit(Integer data_no) throws Exception;


	// 회원이 작성한 게시글 목록
	List<FreeVo> memberFreeList(String mem_id) throws Exception;

	// 회원 프로필 사진 수정
	void updateMemberImg(FreeVo freeVo) throws Exception;

}
