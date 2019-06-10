package org.fkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

	@PostMapping("/search")
	public String search() throws Exception{
		try {
			int i = 5/0;
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			throw new OrderException("订单查询失败!");
		}
		
	}
	
}
