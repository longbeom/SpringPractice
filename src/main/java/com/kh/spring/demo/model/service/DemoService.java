package com.kh.spring.demo.model.service;

import java.util.List;

import com.kh.spring.demo.model.vo.Dev;

public interface DemoService {

	int insertDev(Dev dev);
	List<Dev> selectDemoList();
	int deleteDev(int no);
	Dev selectDev(int no);
	int updateDev(Dev dev);
}
