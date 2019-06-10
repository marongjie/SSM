package org.fkit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController extends BaseController{
	
	@GetMapping("/login")
	public String login(String username) throws Exception{
		if(username == null ){
			throw new NullPointerException("用户名不存在!");
		}
		return "success";
	}
	

	
}
