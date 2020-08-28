package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.StoreDao;
import com.javaex.vo.DogVo;
import com.javaex.vo.ReservationVo;
import com.javaex.vo.ShopVo;
import com.javaex.vo.StorereservationVo;
import com.javaex.vo.UserVo;

@Service
public class StoreService {

	@Autowired
	StoreDao storeDao;
	
	//메인페이지
	public ShopVo StoreMain(String shopDomain) {
		return storeDao.StoreSelect(shopDomain);
	}
	
	public int adminreser(StorereservationVo storereservationvo) {
		return storeDao.adminreser(storereservationvo);
	}
	
	public List<StorereservationVo> restime(StorereservationVo storereservationvo){
		System.out.println("storeservice: restime");
		System.out.println(storereservationvo);
		return storeDao.restime(storereservationvo);
	}
	
	public void insertres(ReservationVo reservationvo) {
		storeDao.insertres(reservationvo);
		System.out.println(reservationvo);
		storeDao.taken(reservationvo);
		
	}
	
	public UserVo getuser(int userNo) {
		return storeDao.getuser(userNo);
	}
	public List<DogVo> getdList(int userNo){
		return storeDao.getdList(userNo);
	}
	public DogVo getdog(DogVo dogvo) {
		return storeDao.getdog(dogvo);
	}
	public List<ReservationVo> getRList(int shopNo){
		return storeDao.getRList(shopNo);
	}
}
