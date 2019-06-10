package org.fkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;



/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */
@Controller
public class CookieValueController{

	// 测试@CookieValue注解
	// 该方法映射的请求为 /cookieValueTest
	@GetMapping(value="/cookieValueTest")
	 public void cookieValueTest(
			 @CookieValue(value="JSESSIONID", defaultValue="") String sessionId) {
		System.out.println("通过@CookieValue获得JSESSIONID： " + sessionId);
	 }

}

