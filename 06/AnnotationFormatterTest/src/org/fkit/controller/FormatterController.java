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


@Controller
public class FormatterController{
	 
	@GetMapping(value="/testForm")
	 public String registerForm(){
		// 跳转到测试表单数据格式化
		return "testForm";
	}
	 
	@PostMapping(value="/test")
	 public String test(
			 @ModelAttribute User user,
			 Model model) {
		 System.out.println(user);
		 model.addAttribute("user", user);
	     return "success";
	 }

}

