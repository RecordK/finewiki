package com.sesac.finewiki.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDAOImpl implements BoardFileDAO{
	
	private static final String NAMESPACE = "com.sesac.finewiki.mappers.upload.BoardFileMapper";
    @Inject
    private SqlSession sqlSession;

	@Override
	public void addAttach(String file_name, int data_no) throws Exception {
		 Map<String, Object> paramMap = new HashMap<String, Object>();
	        paramMap.put("file_name", file_name);
	        paramMap.put("data_no", data_no);
	        sqlSession.insert(NAMESPACE + ".addAttach", paramMap);
	}

	@Override
	public List<String> getAttach(int data_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".getAttach", data_no);

	}

	@Override
	public void replaceAttach(String file_name, int data_no) throws Exception {
		 Map<String, Object> paramMap = new HashMap<String, Object>();
	        paramMap.put("file_name", file_name);
	        paramMap.put("data_no", data_no);
	        sqlSession.insert(NAMESPACE + ".replaceAttach", paramMap);
	}

	@Override
	public void deleteAttach(String file_name) throws Exception {
        sqlSession.delete(NAMESPACE + ".deleteAttach", file_name);

	}

	@Override
	public void deleteAllAttach(int data_no) throws Exception {
        sqlSession.delete(NAMESPACE + ".deleteAllAttach", data_no);
	}

	@Override
	public void updateAttachCnt(int data_no) throws Exception {
		sqlSession.update(NAMESPACE + ".updateAttachCnt", data_no);
	}

}
