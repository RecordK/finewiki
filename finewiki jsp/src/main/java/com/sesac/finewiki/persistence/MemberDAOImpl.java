package com.sesac.finewiki.persistence;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sesac.finewiki.vo.LoginDTO;
import com.sesac.finewiki.vo.MemberVo;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final String NAMESPACE = "com.sesac.finewiki.mappers.member.memberMapper";

	private final SqlSession sqlSession;

	@Inject
	public MemberDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 회원가입처리
	@Override
	public void register(MemberVo vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".register", vo);
	}

	// 로그인 처리
	@Override
	public MemberVo login(LoginDTO loginDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".login", loginDTO);
	}

	// 로그인 유지 처리
	@Override
	public void keepLogin(String mem_id, String session_id, Date sessionLimit) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("session_id", session_id);
		paramMap.put("sessionLimit", sessionLimit);
		sqlSession.update(NAMESPACE + ".keepLogin", paramMap);

	}

	// 세션키 검증
	@Override
	public MemberVo checkUserWithSessionKey(String value) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".checkUserWithSessionKey", value);
	}

	// 회원정보 수정처리
	@Override
	public void updateMember(MemberVo vo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateMember", vo);
	}

	// 회원 비밀번호
	@Override
	public MemberVo getMember(String mem_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getMember", mem_id);
	}

	// 회원 비밀번호 수정처리
	@Override
	public void updatePw(MemberVo vo) throws Exception {
		sqlSession.update(NAMESPACE + "updatePw", vo);

	}

	// 회원 프로필 사진 수정
	@Override
	public void updateMem_image(String mem_id, String mem_img) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("mem_img", mem_img);
		sqlSession.update(NAMESPACE + ".updateMem_image", paramMap);

	}

}
