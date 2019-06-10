package org.fkit.controller;

import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */

// Controller注解用于指示该类是一个控制器，可以同时处理多个请求动作
@Controller
public class ModelAndViewController{

	@RequestMapping(value="/ModelAndViewTest")
	 public ModelAndView ModelAndViewTest(ModelAndView mv){
		System.out.println("ModelAndViewTest");
		User user = new User();
		// 设置user对象的username属性
		user.setUsername("疯狂软件");
		// 将User对象添加到ModelAndView当中
		mv.addObject("user", user);
		// 设置要转发的页面
		mv.setViewName("result");
		return mv;
	}
	

}

