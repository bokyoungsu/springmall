package com.example.springmall.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmall.sample.vo.Sample;

@RestController // json 으로 리턴 
public class RestSampleController { // REST API 
	@RequestMapping(value="/sample/getRestSample")
	public Sample getRestSample() {
		return new Sample(1,"guest","1234"); // 객체형태로 리턴 
	}
}
