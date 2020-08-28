package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.DogVo;

@Repository
public class DogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int add(DogVo dogvo) {
		System.out.println("dogdao:add");
		return sqlSession.insert("dog.add",dogvo);
	}

	public List<DogVo> list(){
		return sqlSession.selectList("dog.list");
	}
	
	public int modify(DogVo dogvo) {
		System.out.println("dogdao:modify");
		return sqlSession.update("dog.modify",dogvo);
	}
}
