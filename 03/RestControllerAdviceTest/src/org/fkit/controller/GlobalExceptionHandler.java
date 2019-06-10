package org.fkit.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @RestController注解本身使用@ControllerAdvicer和@ResponseBody注解。
 * 使用了@RestControllerAdvice注解的类会被看作一个ControllerAdvicer，
 * 而该类中所有使用@ExceptionHandler注解的方法都默认使用了的@ResponseBody注解。
 * */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// 处理OrderException自定义异常
	@ExceptionHandler(value = OrderException.class)
    public Object OrderErrorHandler(Exception e) throws Exception {
		// 创建返回对象Map并设置属性，会被@ResponseBody注解转换为JSON返回
		Map<String, Object> map = new HashMap<>();
		map.put("code", 100);
		map.put("message", e.getMessage());
		map.put("data", "请求失败");
        return map;
    }
	
}
