package com.kh.spring.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.demo.model.service.DemoService;
import com.kh.spring.demo.model.vo.Dev;

@Controller
public class DemoController {

	@Autowired
	DemoService service;
	
	@RequestMapping("/demo/demo.do")
	public String demo() {
		/*service.test();*/
		System.out.println("/demo/demo.do/controller실행!");
		//prefix+return값+suffix
		return "demo/demo";
	}
	
	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest request)
	{
		String devName=request.getParameter("devName");
		int devAge=Integer.parseInt(request.getParameter("devAge"));
		String devEmail=request.getParameter("devEmail");
		String devGender=request.getParameter("devGender");
		String[] devLang=request.getParameterValues("devLang");
		
		Dev dev=new Dev(devName, devAge, devEmail,devGender,devLang);
		request.setAttribute("dev", dev);
		
		System.out.println(devName+devAge+devEmail+devGender+devLang);
		
		return "demo/result";
	}
	
	@RequestMapping("/demo/demo2.do")
	public String demo2(HttpServletRequest req,
					@RequestParam(value="devName") String devName,
					@RequestParam(value="devAge", required=false, defaultValue="19") int devAge,
					@RequestParam(value="devEmail", required=false) String devEmail,
					@RequestParam(value="devGender", required=false) String devGender,
					@RequestParam(value="devLang", required=false) String[] devLang
					)
	/*public String demo2(HttpServletRequest req,
			String devName, int devAge, String devEmail,
			String devGender, String[] devLang) */ 
	{
		req.setAttribute("dev", new Dev(devName,devAge,devEmail,devGender,devLang));
		
		System.out.println(devName+devAge+devEmail+devGender+devLang);
		return "demo/result";
	}
	
	@RequestMapping("/demo/demo3.do")
	public String demo3(Dev dev, Model model) {
		model.addAttribute("dev", dev);
		return "demo/result";
	}
	
	@RequestMapping("/demo/insertDev.do")
	public String insertDev(Dev dev) {
		int result = service.insertDev(dev);
		return "redirect:/";
	}
	
	@RequestMapping("/demo/selectDemoList.do")
	public String selectDemoList(Model model) {		
		List<Dev> list = service.selectDemoList();
		model.addAttribute("list", list);
		return "demo/devList";
	}
	
	@RequestMapping("/demo/updateDev.do")
	public String updateDev(Model model, @RequestParam(value="devNo") int devNo) {
		Dev dev = service.selectDev(devNo);
		model.addAttribute("dev", dev);
		return "demo/updateDev";
	}
	
	@RequestMapping("/demo/updateDevEnd.do")
	public String updateDevEnd(Dev dev, Model model) {
		System.out.println(dev);
		int result = service.updateDev(dev);	
		String msg = "";
		if (result > 0) msg = "수정 성공!";
		else msg = "수정 실패...";
		model.addAttribute("msg", msg);
//		return "common/msg";
		return "redirect:/demo/selectDemoList.do";
	}
	
	@RequestMapping("/demo/deleteDev.do")
	public String deleteDev(@RequestParam(value="devNo") int devNo) {
		int result = service.deleteDev(devNo);		
		return "redirect:/demo/selectDemoList.do";
	}
	
}