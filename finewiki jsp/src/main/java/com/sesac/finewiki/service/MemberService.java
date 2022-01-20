package com.sesac.finewiki.service;

import java.sql.Date;

import com.sesac.finewiki.vo.LoginDTO;
import com.sesac.finewiki.vo.MemberVo;

public interface MemberService {

	// 회원가입처리
	void register(MemberVo data_no) throws Exception;

	// 로그인 처리
	MemberVo login(LoginDTO loginDTO) throws Exception;

	// 로그인 유지
	void keepLogin(String mem_id, String session_id, Date sessionLimit) throws Exception;

	// 회원정보 조회
	MemberVo checkLoginBefore(String value) throws Exception;

	// 회원정보 수정처리
	public void modifyMember(MemberVo data_no) throws Exception;

	// 회원 정보
	public MemberVo getMember(String mem_id) throws Exception;

	// 회원비밀번호 수정처리
	public void modifyPw(MemberVo data_no) throws Exception;

	// 회원 프로필 사진 수정
	public void modifyMem_image(String mem_id, String mem_img) throws Exception;

}
