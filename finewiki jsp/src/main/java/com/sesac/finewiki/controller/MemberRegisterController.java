package com.sesac.finewiki.controller;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sesac.finewiki.service.MemberService;
import com.sesac.finewiki.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberRegisterController {

	private final MemberService memberService;

	@Inject
	public MemberRegisterController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 회원가입 페이지
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET() throws Exception {
		return "/member/register";
	}

	// 회원가입 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(MemberVo vo, RedirectAttributes redirectAttributes) throws Exception {

		String hashedPw = BCrypt.hashpw(vo.getMem_pw(), BCrypt.gensalt());
		vo.setMem_pw(hashedPw);
		memberService.register(vo);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");

		return "redirect:/member/login";
	}

}
