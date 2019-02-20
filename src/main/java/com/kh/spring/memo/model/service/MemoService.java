package com.kh.spring.memo.model.service;

import java.util.List;
import java.util.Map;

public interface MemoService {
	
	int insertMemo(Map map);
	List selectMemoList();
	int deleteMemo(int no);
}
