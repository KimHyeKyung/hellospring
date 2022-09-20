package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.EmaillistVo;

@Repository
public class EmaillistDao {

	// SqlSessionTemplate를 DI한다.
	@Autowired
	private SqlSession sqlSession;

	public List<EmaillistVo> getList() {
		System.out.println("[EmaillistDao] sqlSession.selectList()");
		return sqlSession.selectList("EmaillistXml.list");
	}

	public int insert(EmaillistVo emaillistVo) {
		return sqlSession.insert("EmaillistXml.insert",emaillistVo);
	}

	public int delete(int no) {
		return sqlSession.delete("EmaillistXml.delete",no);
	}

}
