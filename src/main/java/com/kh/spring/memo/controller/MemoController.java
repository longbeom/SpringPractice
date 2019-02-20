package com.kh.spring.memo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.memo.model.service.MemoService;

@Controller
public class MemoController {

	private Logger logger = LoggerFactory.getLogger(MemoController.class);
	
	@Autowired
	MemoService service;
	
	@RequestMapping("/memo/memo.do")
	public ModelAndView memoView() {
		
		logger.debug("메모를 찾아줘!");
		
		
		ModelAndView mv = new ModelAndView();
		List list = service.selectMemoList();
		mv.addObject("memoList", list);
		mv.setViewName("/memo/memo");
		
		logger.debug("content : " + list);
		
		return mv;
	}
	
	@RequestMapping("/memo/insertMemo.do")
	public ModelAndView insertMemo(@RequestParam("memo") String memo,  @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> map = new HashMap();
		map.put("memo", memo);
		map.put("password", password);
		
		int result = service.insertMemo(map);
		String msg = "";
		String loc = "/memo/memo.do";
		
		if(result > 0) {
			msg = "메모 등록 성공!";
		} else {
			msg = "메모 등록 실패...";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("loc", loc);
		mv.setViewName("common/msg");
		
		return mv;
	}
	
	@RequestMapping("/memo/deleteMemo.do")
	public ModelAndView deleteMemo(@RequestParam("no") int no) { 
		ModelAndView mv = new ModelAndView();
		
		int result = service.deleteMemo(no);
		
		String msg = "";
		String loc = "/memo/memo.do";
		
		if(result > 0) {
			msg = "메모 삭제 성공!";
		} else {
			msg = "메모 삭제 실패...";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("loc", loc);
		mv.setViewName("common/msg");
		
		return mv;
	}
}
