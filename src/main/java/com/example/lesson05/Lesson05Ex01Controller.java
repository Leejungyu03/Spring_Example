package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Ex01Controller {
	
	// 요청 url: http://localhost/lesson05/ex01
	@RequestMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	// 요청 url: http://localhost/lesson05/ex02
	@RequestMapping("/ex02")
	public String ex02(Model model) {
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("멜론");
		fruits.add("포도");
		fruits.add("딸기");
		fruits.add("망고");
		
		model.addAttribute("fruits", fruits);
		
		//List <Map>
		List<Map<String, Object>> users = new ArrayList<>();
		
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("name", "신보람");
		userMap.put("age", 25);
		userMap.put("hobby", "독서");
		users.add(userMap);
		
		userMap = new HashMap<>();
		userMap.put("name", "이준규");
		userMap.put("age", 20);
		userMap.put("hobby", "게임");
		users.add(userMap);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
	// 요청 url: http://localhost/lesson05/ex03
	@RequestMapping("/ex03")
	public String ex03(Model model) {
		Date today = new Date();
		model.addAttribute("today", today);
		
		return "lesson05/ex03";
	}
}