package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController    // @Controller + @ResponseBody
public class Lesson01Ex01RestController {
	// 요청 URL: http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해 String을 리턴해본다.";
	}
	
	// 요청 URL: http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> printMap() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		return map;   // json
	}
	
	// 요청 URL: http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data(); // 일반 자바 bean
		data.setId(1);
		data.setName("신보람");
		return data; // 일반 bean 객체도 JSON으로 내려간다.
	}
	
	// 요청 URL: http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data = new Data(); // 일반 자바 bean
		data.setId(1);
		data.setName("신보람");
		
		// 크롬 > Network tab 응답값 확인!
		//return new ResponseEntity<>(data, HttpStatus.OK); // 200 ok
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // 500 error
	}
}