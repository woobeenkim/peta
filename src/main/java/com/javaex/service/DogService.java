package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.DogDao;
import com.javaex.vo.DogVo;

@Service
public class DogService {
	
	@Autowired
	private DogDao dogdao;
	
	public int add(DogVo dogvo) {
		System.out.println("dogservice:add");
		System.out.println(dogvo.toString());
		return dogdao.add(dogvo);
	}
	
	
	public List<DogVo> list(){
		System.out.println("dogservice:list");
		return dogdao.list();
	}
	
	public int modify(DogVo dogvo) {
		System.out.println("dogservice:modify");
		return dogdao.modify(dogvo);
	}

}
