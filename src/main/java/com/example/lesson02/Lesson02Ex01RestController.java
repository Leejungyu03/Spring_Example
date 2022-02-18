package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.model.UsedGoods;

@RestController // @Controller + @ResponseBody
public class Lesson02Ex01RestController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	// 요청 URL : http://localhost:8080/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> getUsedGoods() {
		return usedGoodsBO.getUsedGoodsList();
	}
}
