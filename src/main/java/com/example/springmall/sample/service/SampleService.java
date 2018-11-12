package com.example.springmall.sample.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.springmall.sample.mapper.SampleFileMapper;
import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleFile;
import com.example.springmall.sample.vo.SampleRequest;



@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	
	@Autowired
	private SampleFileMapper sampleFileMapper;
	
	public int loginSample(SampleRequest sampleRequest) {
		System.out.println("SampleService.java.loginSample()");
		Sample sample = new Sample();
		sample.setSampleId(sampleRequest.getSampleId());
		sample.setSamplePw(sampleRequest.getSamplePw());
		int success = 0;
		Sample getSample = new Sample();
		getSample = (Sample) sampleMapper.loginSample(sample);
	
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
	public int modifySample(SampleRequest sampleRequest) {
		System.out.println("SampleService.java.modifySample()");
		Sample sample = new Sample();
		sample.setSampleId(sampleRequest.getSampleId());
		sample.setSamplePw(sampleRequest.getSamplePw());
		int success = sampleMapper.updateSample(sample);;
		if(success == 1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		return success;
	}
	// insert
	public int addSample(SampleRequest sampleRequest,String path) {
		System.out.println("SampleService.java.addSample()");
		Sample sample = new Sample();
		sample.setSampleId(sampleRequest.getSampleId());
		sample.setSamplePw(sampleRequest.getSamplePw());
		int success = sampleMapper.insertSample(sample); // insert 후에 pk값이 sample에 채워진다 .(mybatis세팅)
		
		SampleFile sampleFile = new SampleFile();
		MultipartFile multipartFile = sampleRequest.getMultipartFile();
		// 파일이름 (확장자찾기위해)
		String originalFileName = multipartFile.getOriginalFilename();
		sampleFile.setSampleFilePath(path);
		// 이름.확장자
		int pos = originalFileName.lastIndexOf(".");
		String ext = originalFileName.substring(pos+1);
		sampleFile.setSampleFileExt(ext);
		// 파일이름(저장용 가짜)
		String fileName = UUID.randomUUID().toString();
		sampleFile.setSampleFileName(fileName);
		sampleFile.setSampleFileType(multipartFile.getContentType());
		sampleFile.setSampleFileSize(multipartFile.getSize());
		sampleFile.setSampleNo(sample.getSampleNo());
		
		// sampleRequest -> sample  SampleFile
		// 멀티파트 - > 저장 
		// 멀티파트 정보 - > 새로운 정보 추가  ->SampleFile
		// 만약 설정한 경로에 디렉토리가없다면 새로운 디렉토리생성 
		File dir = new File(path); 
		if (!dir.isDirectory()) { 
				dir.mkdirs(); 
		}
		System.out.println(sampleFile+"<--sampleFile");
		sampleFileMapper.insertSampleFile(sampleFile);
		
		try {
			multipartFile.transferTo(new File(path+"/"+fileName+"."+ext));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		
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
