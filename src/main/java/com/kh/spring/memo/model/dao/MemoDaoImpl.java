package com.kh.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDaoImpl implements MemoDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int insertMemo(Map map) {
		return sqlSession.insert("insertMemo", map);
	}

	@Override
	public List selectMemoList() {
		return sqlSession.selectList("selectMemoList");
	}

	@Override
	public int deleteMemo(int no) {
		return sqlSession.delete("deleteMemo", no);
	}	
}
