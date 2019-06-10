package org.fkit.controller;

import java.util.Date;
import org.fkit.converter.DateEditor;
import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */


@Controller
public class UserController{
	
	@GetMapping(value="/registerForm")
	 public String registerForm(){
		// 跳转到注册页面
		return "registerForm";
	}
	
	 // 在控制器初始化时注册属性编辑器
	 @InitBinder
	  public void initBinder(WebDataBinder binder){
		// 注册自定义编辑器
		binder.registerCustomEditor(Date.class, new DateEditor());
	  }
	 
	 @PostMapping(value="/register")
	 public String register(
			 @ModelAttribute User user,
			 Model mode) {
		 System.out.println(user);
	     mode.addAttribute("user", user);
	     return "success";
	 }

}

