package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 요청 URL : http://localhost/lesson06/ex01/add_new_user
	@RequestMapping("/add_new_user")
	public String adduserView() {
		return "/lesson06/add_new_user";
	}
	
	// 유저 추가
	// 요청 URL : http://localhost/lesson06/ex01/add_new_user
	// AJAX가 요청하는 경우 @ResponseBody가 있어야 한다.
	// AJAX가 요청한느 응답값은 String이다.
	@ResponseBody
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required=false) String introduce) {
		
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "성공";
	}
	
	@RequestMapping("/get_user_view")
	public String getUserView() {
		return "lesson06/get_user";
	}
}
