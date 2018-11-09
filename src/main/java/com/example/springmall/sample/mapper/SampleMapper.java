package com.example.springmall.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

@Mapper
public interface SampleMapper {
	// 전체회원조회
	List<Sample> selectSampleAll(int startRow,int rowPerPage);
	// totalcount 조회 페이징에필요
	int selectCountSample();
	// 회원가입
	int insertSample(Sample sample);
	// 회원삭제
	int deleteSample(int sampleNo);
	// 회원수정
	int updateSample(Sample sample);
	// 수정할 회원 조회
	Sample selectOne(int sampleNo);
	// 로그인 체크
	Sample loginSample(Sample sample);
}
