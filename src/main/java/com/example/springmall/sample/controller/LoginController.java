package com.example.springmall.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class LoginController {
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/loginSample",method=RequestMethod.GET)
	public String loginSample() {
		System.out.println("LoginCountroller.java.loginSample().GET");
		return "/sample/loginSample";
	}
	@RequestMapping(value="/sample/loginSample",method=RequestMethod.POST)
	public String loginSample(HttpSession session,Sample sample) {
		String path = "";
		int success;
		System.out.println("LoginCountroller.java.loginSample().POST");
		
		success = sampleService.loginSample(sample);
		System.out.println(success);
		if(success == 1) {
			session.setAttribute("sId", sample.getSampleId());
			path = "redirect:/sample/sampleList";
		}else {
			path = "redirect:/sample/loginSample";
		}
		return path;
	}

	@RequestMapping(value="/sample/logoutSample",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/sample/sampleList";
	}
}
