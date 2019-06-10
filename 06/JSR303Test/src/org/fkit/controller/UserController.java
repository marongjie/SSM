package org.fkit.controller;


import javax.validation.Valid;
import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
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
	 public String registerForm(Model model){
		User user = new User();
		model.addAttribute("user",user);
		// 跳转到注册页面
		return "registerForm";
	}
	 
	// 数据校验使用@Valid，后面跟着Errors对象保存校验信息
	 @PostMapping(value="/login")
	 public String login(
			 @Valid @ModelAttribute  User user,
			 Errors  errors,
			 Model model) {
		 System.out.println(user);
		 if(errors.hasErrors()){
			 return "registerForm";
		 }
		 model.addAttribute("user", user);
	     return "success";
	 }

}

