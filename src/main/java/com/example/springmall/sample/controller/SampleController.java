package com.example.springmall.sample.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleRequest;
/* @Controller는 Spring MVC의 Controller 클래스 선언을 단순화. 스프링 컨트롤러, 서블릿을 상속할 필요가 없으며, @Controller로 등록된 클래스 파일에 대한 bean을 자동으로 생성해준다
(component-scan 이용)*/
@Controller
public class SampleController {
	// @Autowired은 의존관계를 자동설정할 때 사용하며 타입을 이용하여 의존하는 객체를 삽입해 준다. (해당 타입의 빈객체가 존재하지 않거나 또는 2개 이상 존재할 경우 스프링은 예외를 발생시킨다.)
	// 주입 
	@Autowired
	private SampleService sampleService;
	
	/*@RequestMapping은 URL을 컨트롤러의 메서드와 매핑할 때 사용하는 스프링 프레임워크의 어노테이션이다.
	클래스나 메서드 선언부에 @RequestMapping과 함께 URL을 명시하여 사용한다. URL외에도 HTTP 요청 메서드나 헤더값에 따라 매핑되도록 -0=옵션을 제공한다. 메서드 레벨에서 정의한 @RequestMapping은 타입 레벨에서 정의된 @RequestMapping의 옵션을 상속받는다.
	참고로, 메서드 내에서 viewName을 별도로 설정하지 않으면 @RequestMapping의 path로 설정한 URL이 그대로 viewName으로 설정된다*/
	// 수정 메서드 (update할 멤버를 가지고  update form 으로이동 )
	@RequestMapping(value="/sample/modifySample",method=RequestMethod.GET)
	public String modifySample(Model model,@RequestParam(value="sampleNo")int sampleNo) {
		System.out.println("SampleCountroller.java.modifySample().GET");
		Sample sample =  sampleService.getSample(sampleNo);
		model.addAttribute("sample",sample);
		return "/sample/modifySample";
	}
	// 수정 액션 (update member)
	@RequestMapping(value="/sample/modifySample",method=RequestMethod.POST)
	public String modifySample(SampleRequest sampleRequest) {
		System.out.println("SampleCountroller.java.modifySample().POST");
		sampleService.modifySample(sampleRequest);
		return "redirect:/sample/sampleList";
	
	}
	// 입력 메서드(insert from 으로이동)
	@RequestMapping(value="/sample/addSample",method=RequestMethod.GET)
	public String addSample() {
		System.out.println("SampleCountroller.java.addSample().GET");
		return "/sample/addSample";
		
	}
	// 입력 액션 메서드(insert action)
	@RequestMapping(value="/sample/addSample",method=RequestMethod.POST)
	public String addSample(SampleRequest sampleRequest,HttpSession session) { // command 객체 
		System.out.println("SampleCountroller.java.addSample().POST");
		// command 객체의 멤버변수 == input 태그 name 속성 
		String path = session.getServletContext().getRealPath("\\WEB-INF\\uploads");
		sampleService.addSample(sampleRequest,path);
		return "redirect:/sample/sampleList";
	}
	// 리스트 메서드(select member)
	@RequestMapping(value="/sample/sampleList",method=RequestMethod.GET)
	public String sampleList(Model model,@RequestParam(value="startRow",required=false,defaultValue="0") int startRow) {
		System.out.println("SampleController.java.sampleList().GET");
		List<Sample> sampleList = sampleService.getSampleAll(startRow);
		int totalCount = sampleService.getTotalCount();
		model.addAttribute("startRow",startRow);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("sampleList",sampleList);
		return "/sample/sampleList";
		
	}

	@RequestMapping(value="/sample/viewDetails",method=RequestMethod.GET)
	public String viewDetails(@RequestParam(value="sampleNo") int sampleNo) {
		System.out.println("SampleController.java.viewDetails()");
		sampleService.
		return "/sample/viewDetails";
	}
	// 삭제 메서드 (delete member)
	@RequestMapping(value="/sample/removeSample",method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) {
		System.out.println("SampleController.java.removeSample().GET");
		sampleService.removeSample(sampleNo); 
		return "redirect:/sample/sampleList";
	}
}
