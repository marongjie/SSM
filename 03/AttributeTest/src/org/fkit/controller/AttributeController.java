package org.fkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;



/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */
@Controller
public class AttributeController{

	// 测试@CookieValue注解
	// 该方法映射的请求为 /cookieValueTest
	@GetMapping(value="/attrbuteTest")
	 public ModelAndView attrbuteTest(ModelAndView mv) {
		System.out.println("attributeTest方法被调用...");
		 // 客户端重定向到main请求，会被自定义过滤器拦截
		 mv.setViewName("redirect:main");;
		 return mv;
	 }
	
	/*
	 *  该方法映射的请求为/main
	 *  @RequestAttribute("school")会获取request作用范围中名为"school"的属性的值赋给school变量
	 *  @SessionAttribute("author")会获取session作用范围中名为"author"的属性的值赋给author变量
	 */
	 @RequestMapping("/main")
	 public String main(
			 @RequestAttribute("school") String school,
			 @SessionAttribute("author") String author) {
		 System.out.println("main方法被调用...");
		 // 输出@RequestAttribute获得的school
		 System.out.println("school: " + school);
		// 输出@SessionAttribute获得的author
		 System.out.println("author: " + author);
		 
	     return "welcome";
	 }

}

