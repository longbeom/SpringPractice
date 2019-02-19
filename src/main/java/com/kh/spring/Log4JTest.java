package com.kh.spring;

import org.apache.log4j.Logger;

import com.kh.spring.demo.model.vo.Dev;

public class Log4JTest {

	private Logger logger = Logger.getLogger(Log4JTest.class);
	
	public static void main(String args[]) {
		new Log4JTest().test();
	}
	
	public void test() {
		Dev dev = new Dev();
		dev.setDevName("유병승");
		dev.setDevEmail("prince");
		logger.fatal("fatal-!");
		logger.error("error-!");
		logger.warn("warn-!");
		logger.info("info-!");
		logger.debug("debug-!" + dev);
	}
}
