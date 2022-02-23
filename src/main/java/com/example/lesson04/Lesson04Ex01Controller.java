package com.example.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Lesson04Ex01Controller {
	
	// 요청 : http://localhost/lesson04/ex01/1
	@RequestMapping(path="/lesson04/ex01/1", method = RequestMethod.GET)
	public String ex01() {
		
		//	/WEB-INF/jsp/	.jsp
		//	/WEB-INF/jsp/lesson04/add_user.jsp
		return "lesson04/add_user"; // view 경로
	}
	
	// 405 에러: Request method 불일치
	// 요청: http://localhost/lesson04/ex01/add_user
	@PostMapping("/lesson04/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required = false) String introduce) {
		// insert DB 
		
		// 결과 jsp
		return "/lesson04/after_add_user"; // 결과 jsp 경로
	}
}
