package org.fkit.controller;

import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;




/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */

// Controller注解用于指示该类是一个控制器，可以同时处理多个请求动作
@Controller
public class ModelController{

	@RequestMapping(value="/modelTest")
	 public String modelTest(Model model){
		System.out.println("modelTest");
		User user = new User();
		// 设置user对象的username属性
		user.setUsername("疯狂软件");
		// 将User对象添加到Model当中
		model.addAttribute("user", user);
		return "result1";
	}
	
	@RequestMapping(value="/ModelMapTest")
	 public String ModelMapTest(ModelMap modelMap){
		System.out.println("ModelMapTest");
		User user = new User();
		// 设置user对象的username属性
		user.setUsername("疯狂软件");
		// 将User对象添加到ModelMap当中
		modelMap.addAttribute("user", user);
		return "result2";
	}
	
	

}

