package com.sesac.finewiki.controller;

import java.sql.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.sesac.finewiki.service.MemberService;
import com.sesac.finewiki.vo.LoginDTO;
import com.sesac.finewiki.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberLoginController {

	private final MemberService memberService;

	@Inject
	public MemberLoginController(MemberService memberService) {
		this.memberService = memberService;

	}

	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
		return "/member/login";
	}

	// 로그인 처리
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO loginDTO, HttpSession httpSession, Model model) throws Exception {

		MemberVo vo = memberService.login(loginDTO);

		if (vo == null || !BCrypt.checkpw(loginDTO.getMem_pw(), vo.getMem_pw())) {
			return;
		}

		model.addAttribute("member", vo);

		// 로그인 유지를 선택할 경우
		if (loginDTO.isUseCookie()) {
			int amount = 60 * 60 * 24 * 7; // 7일
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount)); // 로그인 유지기간 설정
			memberService.keepLogin(vo.getMem_id(), httpSession.getId(), sessionLimit);
		}
	}

	// 로그아웃 처리
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws Exception {

		Object object = httpSession.getAttribute("login");

		if (object != null) {
			MemberVo vo = (MemberVo) object;
			httpSession.removeAttribute("login");
			httpSession.invalidate();
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				memberService.keepLogin(vo.getMem_id(), "none", new Date(0));
			}
		}

		return "/member/logout";

	}

}
