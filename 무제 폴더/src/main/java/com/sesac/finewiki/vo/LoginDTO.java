package com.sesac.finewiki.vo;

public class LoginDTO {

	private String mem_id;
	private String mem_pw;
	private boolean useCookie;

	public LoginDTO() {
	}

	public LoginDTO(String mem_id, String mem_pw, boolean useCookie) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.useCookie = useCookie;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", useCookie=" + useCookie + "]";
	}

}
