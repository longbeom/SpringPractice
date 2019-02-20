package com.kh.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

public interface MemoDao {

	int insertMemo(Map map);
	List selectMemoList();
	int deleteMemo(int no);
}
