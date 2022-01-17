package com.sesac.finewiki.service;

import java.sql.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sesac.finewiki.persistence.MemberDAO;
import com.sesac.finewiki.vo.LoginDTO;
import com.sesac.finewiki.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	private final MemberDAO memberDAO;

	@Inject
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	// 회원 가입 처리
	@Override
	public void register(MemberVo vo) throws Exception {
		memberDAO.register(vo);
	}

	@Override
	public MemberVo login(LoginDTO loginDTO) throws Exception {
		return memberDAO.login(loginDTO);
	}

	@Override
	public void keepLogin(String mem_id, String session_id, Date sessionLimit) throws Exception {
		memberDAO.keepLogin(mem_id, session_id, sessionLimit);
	}

	@Override
	public MemberVo checkLoginBefore(String value) throws Exception {
		return memberDAO.checkUserWithSessionKey(value);
	}

	// 회원정보 수정처리
	@Override
	public void modifyMember(MemberVo vo) throws Exception {
		memberDAO.updateMember(vo);
	}

	// 회원 비밀번호
	@Override
	public MemberVo getMember(String mem_id) throws Exception {
		return memberDAO.getMember(mem_id);
	}

	// 회원 비밀번호 수정처리
	@Override
	public void modifyPw(MemberVo vo) throws Exception {
		memberDAO.updatePw(vo);
	}

	// 회원 프로필 사진 수정
	@Override
	public void modifyMem_image(String mem_id, String mem_img) throws Exception {
		memberDAO.updateMem_image(mem_id, mem_img);
	}

}
