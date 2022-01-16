package com.sesac.finewiki.persistence;

import java.sql.Date;

import com.sesac.finewiki.vo.LoginDTO;
import com.sesac.finewiki.vo.MemberVo;

public interface MemberDAO {

	// 회원가입처리
	void register(MemberVo vo) throws Exception;

	// 로그인 처리
	MemberVo login(LoginDTO loginDTO) throws Exception;

	// 로그인 유지 처리
	void keepLogin(String mem_id, String session_id, Date sessionLimit) throws Exception;

	// 세션키 검증
	MemberVo checkUserWithSessionKey(String value) throws Exception;

	// 회원정보 수정처리
	public void updateMember(MemberVo vo) throws Exception;

	// 회원 비밀번호
	public MemberVo getMember(String mem_id) throws Exception;

	// 회원비밀번호 수정처리
	public void updatePw(MemberVo vo) throws Exception;

	// 회원 프로필 사진 수정
	public void updateMem_image(String mem_id, String mem_img) throws Exception;

}
