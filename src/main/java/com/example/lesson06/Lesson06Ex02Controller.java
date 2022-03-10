package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private UserBO userBO ;
	
	// 요청 URL : http://localhost/lesson06/ex02/add_user
	@RequestMapping("/add_user")
	public String addUserName() {
		return "/lesson06/add_user";
	}
	
	// 중복 확인 - ajax 요청
	@ResponseBody
	@RequestMapping("/is_duplication")
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", userBO.existUserByName(name));
		
		return result;
	}
}
