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
	
	// ��û URL: http://localhost/lesson04/ex01/1
	@RequestMapping(method = RequestMethod.GET, path = "/ex01/1")
	public String addUserView() {
		return "lesson04/add_user"; // view ���
	}
	
	// ��û URL: http://localhost/lesson04/ex01/add_user
	@PostMapping("/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "introduce", required=false) String introduce,
			@RequestParam("email") String email) {
		
		// DB insert
		newUserBO.addUser(name, yyyymmdd, introduce, email);

		return "lesson04/after_add_user"; // ��� jsp
	}
	
	// ��û URL: http://localhost/lesson04/ex01/add_user
	@GetMapping("/ex01/2")
	public String getUserView(Model model) { // view ȭ�鿡 �����͸� �Ѱ��ִ� ��ü(ModelAndView�� ���� �� ������� �ʴ´�.)
		// DB select - ���� �ֱٿ� �߰��� ��� �Ѹ� ��������
		User newUser = newUserBO.getLastUser();
		model.addAttribute("result", newUser); // ��� jsp View�� ��� ��ü���� �Ѱ��ش�.
		model.addAttribute("subject", "ȸ�� ����");		

		return "lesson04/get_last_user"; // ��� jsp
	}
}