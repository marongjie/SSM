package org.fkit.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

	@ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
        mav.addObject("ex", e);
        mav.setViewName("error");
        return mav;
    }
	
}
