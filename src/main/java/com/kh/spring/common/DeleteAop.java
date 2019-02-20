package com.kh.spring.common;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Component		// bean 등록
@Aspect			// Aop 객체 선언
public class DeleteAop {

	@Pointcut("execution(* com.kh.spring..*(delete))")
	public void myBefore() {}
	
	@Before("myBefore()")
	public ModelAndView before() {
		ModelAndView mv = new ModelAndView();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String userId = (String)request.getSession().getAttribute("userId");
		String msg ="";
		String loc ="/";
		if(!(userId != null && userId.equals("admin"))) {
			msg = "관리자만 가능한 권한입니다.";
			mv.addObject("loc", loc);
			mv.addObject("msg", msg);
		}
		mv.setViewName("common/msg");
		
		return mv;
	}
}
