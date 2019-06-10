package org.fkit.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	// 处理Exception类型异常
	@ExceptionHandler(value = Exception.class)
    public ModelAndView globalErrorHandler(Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
        mav.addObject("ex", e);
        mav.setViewName("error");
        return mav;
    }
	
	// 处理OrderException自定义异常
	@ExceptionHandler(value = OrderException.class)
	@ResponseBody
    public Object OrderErrorHandler(Exception e) throws Exception {
		// 创建返回对象Map并设置属性，会被@ResponseBody注解转换为JSON返回
		Map<String, Object> map = new HashMap<>();
		map.put("code", 100);
		map.put("message", e.getMessage());
		map.put("data", "请求失败");
        return map;
    }
	
}
