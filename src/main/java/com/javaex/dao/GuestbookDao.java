package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	// SqlSessionTemplate를 DI한다.
	@Autowired
	private SqlSession sqlSession;

	public List<GuestbookVo> getList() {
		System.out.println("----> sqlSession.selectList()");
		return sqlSession.selectList("GuestBookXml.selectList");
	}

	//등록
	public int insert(GuestbookVo guestbookVo) {
		return sqlSession.insert("GuestBookXml.insert",guestbookVo);
	}
	
	//삭제
	public int delete(GuestbookVo vo) {
		return sqlSession.delete("GuestBookXml.delete",vo);		
	}

}
