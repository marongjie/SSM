package org.fkit.controller;

import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */

/**
 *  HelloWorldController是一个基于注解的控制器,
 *  可以同时处理多个请求动作，并且无须实现任何接口。
 *  org.springframework.stereotype.Controller注解用于指示该类是一个控制器
 */
@Controller
public class UserController{
	 
	@GetMapping(value="/registerForm")
	 public String registerForm(){
		// 跳转到注册页面
		return "registerForm";
	}
	 
	 @PostMapping(value="/register")
	 public String register(
			 @ModelAttribute User user,
			 Model model) {
		 System.out.println(user);
		 model.addAttribute("user", user);
	     return "success";
	 }

}

