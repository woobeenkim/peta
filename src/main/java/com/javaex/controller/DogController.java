package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.DogService;
import com.javaex.vo.DogVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/dog")
public class DogController {

	@Autowired
	private DogService dogservice;
	
	@RequestMapping("dogbasic")
	public String petbasic(Model model) {
		System.out.println("dogcontroller:petbasic"); 
			System.out.println("boardContoller/list");
			List<DogVo> dogList = dogservice.list();
			model.addAttribute("dogList", dogList);
			System.out.println(dogList.toString());
		return "dog/petBasic";
	}
	
	@RequestMapping("dogaddform")
	public String petaddfrom() {
		System.out.println("dogcontroller:petaddform");
		return "dog/petAdd";
	}
	
	@RequestMapping("dogadd")
	public String petadd(@ModelAttribute DogVo dogvo, HttpSession session) {
		System.out.println("dogcontroller:petadd");
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		System.out.println(authUser.toString());
		dogvo.setUserNo(authUser.getUserNo());
		System.out.println(dogvo.toString());
		dogservice.add(dogvo);
		return "redirect:/dog/dogbasic";
	}
	
	@RequestMapping("dogmodify")
	public String dogmodify(@ModelAttribute DogVo dogvo) {
		System.out.println(dogvo.toString());
		dogservice.modify(dogvo);
		return "redirect:/dog/dogbasic";
	}
}
