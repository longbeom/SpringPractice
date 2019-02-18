package com.kh.spring.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.dao.DemoDao;
import com.kh.spring.demo.model.vo.Dev;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	DemoDao dao;

	@Override
	public int insertDev(Dev dev) {
		return dao.insertDev(dev);		
	}

	@Override
	public List<Dev> selectDemoList() {
		return dao.selectDemoList();		
	}

	@Override
	public int deleteDev(int no) {
		return dao.deleteDev(no);
	}

	@Override
	public Dev selectDev(int no) {		
		return dao.selectDev(no);
	}

	@Override
	public int updateDev(Dev dev) {
		return dao.updateDev(dev);
	}
	
	
}
