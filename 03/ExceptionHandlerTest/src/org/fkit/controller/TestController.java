package org.fkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController{

	@GetMapping("/test")
	public String test() throws Exception{
		// 模拟异常
		int i = 5/0;
		return "success";
	}
	
	/**
	 * 在异常抛出的时候，Controller会使用@ExceptionHandler注解的方法去处理异常
	 * */
	@ExceptionHandler(value = Exception.class)
	public ModelAndView testErrorHandler(Exception e)  {
		ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("ex", e);
        return mav;
	}
	
}
