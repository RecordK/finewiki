package com.sesac.finewiki.persistence;

import java.util.List;

public interface BoardFileDAO {
	// 게시글 첨부파일 추가
    public void addAttach(String file_name, int data_no) throws Exception;

    // 게시글 첨부파일 조회
    public List<String> getAttach(int data_no) throws Exception;

    // 게시글 첨부파일 수정
    public void replaceAttach(String file_name, int data_no) throws Exception;

    // 게시글 첨부파일 삭제
    public void deleteAttach(String file_name) throws Exception;

    // 게시글 첨부파일 일괄 삭제
    public void deleteAllAttach(int data_no) throws Exception;

    // 특정 게시글의 첨부파일 갯수 갱신
    public void updateAttachCnt(int data_no) throws Exception;
}
