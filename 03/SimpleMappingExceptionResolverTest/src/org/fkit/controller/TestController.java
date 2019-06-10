package org.fkit.controller;


import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController{
	
	@GetMapping("/hello")
	public String hello() throws Exception{
		// 抛出异常
		throw new Exception();
	}
	
	@GetMapping("/test")
	public String test() throws Exception{
		// 模拟异常
		int i = 5/0;
		return "success";
	}
	
	@GetMapping("/find")
	public String find() throws Exception{
		try {
			// 模拟异常
			int i = 5/0;
			return "success";
		} catch (Exception e) {
			throw new SQLException("查找数据失败!");
		}
		
	}
	
}
