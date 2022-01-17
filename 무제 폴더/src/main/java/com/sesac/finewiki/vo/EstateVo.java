package com.sesac.finewiki.vo;

import java.util.Arrays;

public class EstateVo {
	private int data_no, board_no, hit;
	private String mem_nick, title, content, regdate;
	private int reply_cnt;
	private String memberImg;
	private MemberVo membervo;
	private String[] files;
	private int fileCnt;

	public EstateVo() {
		// TODO Auto-generated constructor stub
	}


	public EstateVo(int data_no, int board_no, int hit, String mem_nick, String title, String content, String regdate,
			int reply_cnt, String memberImg, MemberVo membervo, String[] files, int fileCnt) {
		super();
		this.data_no = data_no;
		this.board_no = board_no;
		this.hit = hit;
		this.mem_nick = mem_nick;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.reply_cnt = reply_cnt;
		this.memberImg = memberImg;
		this.membervo = membervo;
		this.files = files;
		this.fileCnt = fileCnt;
	}


	public MemberVo getMembervo() {
		return membervo;
	}


	public void setMembervo(MemberVo membervo) {
		this.membervo = membervo;
	}


	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}


	public int getData_no() {
		return data_no;
	}

	public void setData_no(int data_no) {
		this.data_no = data_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getReply_cnt() {
		return reply_cnt;
	}


	public String getMemberImg() {
		return memberImg;
	}

	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}

	public MemberVo getMemberVo() {
		return membervo;
	}

	public void setMemberVo(MemberVo membervo) {
		this.membervo = membervo;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public int getFileCnt() {
		return fileCnt;
	}

	public void setFileCnt(int fileCnt) {
		this.fileCnt = fileCnt;
	}

	@Override
	public String toString() {
		return "BoardVo [data_no=" + data_no + ", board_no=" + board_no + ", hit=" + hit + ", mem_nick=" + mem_nick
				+ ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", reply_cnt=" + reply_cnt
				+ ", memberImg=" + memberImg + ", membervo=" + membervo + ", files=" + Arrays.toString(files) + ", fileCnt="
				+ fileCnt + "]";
	}

}
