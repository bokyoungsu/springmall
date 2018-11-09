package com.example.springmall.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	
	public int loginSample(Sample sample) {
		int success = 0;
		Sample getSample = new Sample();
		getSample = (Sample) sampleMapper.loginSample(sample);
		System.out.println(sample.getSampleId()+"<-넣은값");
		System.out.println(getSample.getSampleId()+"<-결과");
		System.out.println(sample.getSamplePw()+"넣은값");
		System.out.println(getSample.getSamplePw()+"<-결과");
		if(sample.getSampleId().equals(getSample.getSampleId()) && sample.getSamplePw().equals(getSample.getSamplePw())) {
			System.out.println("01로그인성공");
			success = 1;
		}else {
			System.out.println("02로그인실패");
			success = 2;
		}
		return success;
	}
	
	// 수정폼 
	public Sample getSample(int sampleNo) {
		System.out.println("SampleService.java.getSample()");
		return sampleMapper.selectOne(sampleNo);
	}
	// 수정액션
	public int modifySample(Sample sample) {
		System.out.println("SampleService.java.modifySample()");
		int success = sampleMapper.updateSample(sample);;
		if(success == 1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		return success;
	}
	// insert
	public int addSample(Sample sample) {
		System.out.println("SampleService.java.addSample()");
		int success = sampleMapper.insertSample(sample);
		if(success == 1) {
			System.out.println("가입성공");
		}else {
			System.out.println("가입실패");
		}
		return success;
	}
	
	int startRow = 0;
	int rowPerPage = 10;
	int totalCount;
	// 1
	public int getTotalCount() {
		System.out.println("SampleService.java.getTotalCount()");
		return totalCount = sampleMapper.selectCountSample();
	}

	public List<Sample> getSampleAll(int startRow){
		System.out.println("SampleService.java.getSampleAll()");
		return sampleMapper.selectSampleAll(startRow,rowPerPage);
	}
	public int removeSample(int sampleNo) {
		System.out.println("SampleService.java.removeSample()");
		int success = sampleMapper.deleteSample(sampleNo);
		if(success == 1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		return success;
	}
}
