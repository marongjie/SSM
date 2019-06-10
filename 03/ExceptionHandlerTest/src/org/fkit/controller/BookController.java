package org.fkit.controller;


import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController extends BaseController{
	
	@GetMapping("/find")
	public String find() throws Exception{
		try {
			int i = 5/0;
			return "success";
		} catch (Exception e) {
			throw new SQLException("查找图书信息失败!");
		}
		
	}

}
