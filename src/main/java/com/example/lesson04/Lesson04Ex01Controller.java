package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@RequestMapping("/lesson04")
@Controller
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO newUserBO;
	
	// 요청 URL: http://localhost/lesson04/ex01/1
	@RequestMapping(method = RequestMethod.GET, path = "/ex01/1")
	public String addUserView() {
		return "lesson04/add_user"; // view 경로
	}
	
	// 요청 URL: http://localhost/lesson04/ex01/add_user
	@PostMapping("/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "introduce", required=false) String introduce,
			@RequestParam("email") String email) {
		
		// DB insert
		newUserBO.addUser(name, yyyymmdd, introduce, email);

		return "lesson04/after_add_user"; // 결과 jsp
	}
	
	// 요청 URL: http://localhost/lesson04/ex01/add_user
	@GetMapping("/ex01/2")
	public String getUserView(Model model) { // view 화면에 데이터를 넘겨주는 객체(ModelAndView는 요즘 잘 사용하지 않는다.)
		// DB select - 가장 최근에 추가된 사람 한명 가져오기
		User newUser = newUserBO.getLastUser();
		model.addAttribute("result", newUser); // 결과 jsp View에 결과 객체값을 넘겨준다.
		model.addAttribute("subject", "회원 정보");		

		return "lesson04/get_last_user"; // 결과 jsp
	}
}