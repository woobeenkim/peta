package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pet")
public class PetController {

	@RequestMapping("/petBasic")
	public String petBasic() {
		return "pet/petBasic";
	}
	
	@RequestMapping("/petAdd")
	public String petAdd() {
		return "pet/petAdd";
	}
}
