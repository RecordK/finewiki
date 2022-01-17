package com.sesac.finewiki.persistence;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.EstateVo;

public interface EstateDAO {

	void create(EstateVo estateVo) throws Exception;

	EstateVo read(Integer data_no) throws Exception;

	void update(EstateVo boardVo) throws Exception;

	void delete(Integer data_no) throws Exception;

	List<EstateVo> listAll() throws Exception;

	List<EstateVo> listPaging(int page) throws Exception;

	List<EstateVo> listCriteria(Criteria criteria) throws Exception;

	int countEstates(Criteria criteria) throws Exception;

	List<EstateVo> listSearch(SearchCriteria searchCriteria) throws Exception;

	int countSearchedEstates(SearchCriteria searchCriteria) throws Exception;

	void updateReplyCnt(Integer data_no, int amount) throws Exception;
	
	void updateHit(Integer data_no) throws Exception;


	// 회원이 작성한 게시글 목록
	List<EstateVo> memberEstateList(String mem_id) throws Exception;

	// 회원 프로필 사진 수정
	void updateMemberImg(EstateVo estateVo) throws Exception;

}
