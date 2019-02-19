package com.kh.spring.member.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

@SessionAttributes("userId") // Object
@Controller
public class MemberController {
	private Logger logger = Logger.getLogger(MemberController.class);

	@Autowired
	MemberService service;
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@RequestMapping("/member/memberLogin.do")
//	public String login(Member member, Model model) {
	public ModelAndView login(Member member, Model model) {		
		String msg = "";
		ModelAndView mv = new ModelAndView();
		
		// 로그 찍어보기
		logger.debug("로그인 제대로 들어옴!");
		logger.debug("userId : " + member.getUserId() + "password : " + member.getPassword());
		
		Member logined = service.login(member);
		logger.debug("로그인 결과 : " + logined);
		
		if(logined != null) {
			if(pwEncoder.matches(member.getPassword(), logined.getPassword())) {
				msg = "로그인 성공!";
//				model.addAttribute("userId", logined.getUserId());
//				session.setAttribute("userId", logined.getUserId());
				mv.addObject("userId",logined.getUserId());
			} else {
				msg = "비밀번호가 일치하지 않습니다..";
			}
		}
		else {
			msg = "존재하지 않는 아이디입니다..";
		}

//		model.addAttribute("msg", msg);
		mv.addObject("msg", msg);
		
		mv.setViewName("common/msg");
		
		return mv;
	}
	
	@RequestMapping("member/memberLogout.do")
	public String memberLogout(SessionStatus status) {
		// SessionAttributes 등록 로그인이면 sessionStatus 객체의
		// setComplete()메소드 이용 로그아웃 처리
		// HttpSession이용 로그인이면 HttpSession.invalide()
		if(!status.isComplete()) {
			status.setComplete();
		}		
		return "redirect:/";
	}
	
	@RequestMapping("/member/enrollView.do")
	public String enrollView() {		
		return "member/memberEnroll";
	}
	
	@RequestMapping("/member/memberEnrollEnd.do")
	public String memberEnroll(Member member, Model model) {
		String rawPw = member.getPassword();
		member.setPassword(pwEncoder.encode(rawPw));
		
		int result = service.enrollMember(member);
		String msg =""; 
		if(result > 0) {
			msg="회원 가입 성공!";
		}
		else {
			msg="회원가입 실패...";
		}
		model.addAttribute("msg", msg);
		return "common/msg";
	}
	
	@RequestMapping("/member/myPage.do")
	public ModelAndView myPage(@ModelAttribute("userId") String userId) {
		ModelAndView mv = new ModelAndView();
		
		Member member = service.loginedMember(userId);		
		mv.addObject("member", member);
		mv.setViewName("member/myPage");
		
		return mv;
	}
	
	@RequestMapping("/member/memberUpdate.do")
	public ModelAndView memberUpdate(Member member) {
		ModelAndView mv = new ModelAndView();
		int result = service.memberUpdate(member);
		
		String msg = "";
		if (result > 0) msg = "수정 성공!";
		else msg = "수정 실패...";
		String loc = ("/member/myPage.do");
		mv.addObject("msg",msg);
		mv.addObject("loc",loc);
		mv.setViewName("common/msg");
		
		return mv;
	}
}
