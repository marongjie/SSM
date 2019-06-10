package org.fkit.controller;

import org.fkit.domain.User;
import org.fkit.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	 
	// 注入UserValidator对象
	@Autowired
	@Qualifier("userValidator")
	private UserValidator userValidator;
	
	@GetMapping(value="/loginForm")
	 public String loginForm(Model model){
		User user = new User();
		model.addAttribute("user",user);
		// 跳转到登录页面
		return "loginForm";
	}
	 
	 @PostMapping(value="/login")
	 public String login(
			 @ModelAttribute User user,
			 Model model,
			 Errors errors) {
		 System.out.println(user);
		 model.addAttribute("user", user);
		 // 调用userValidator的验证方法
		 userValidator.validate(user, errors);
		 // 如果验证不通过跳转到loginForm视图
		 if(errors.hasErrors()){
			 return "loginForm";
		 }
	     return "success";
	 }

}

