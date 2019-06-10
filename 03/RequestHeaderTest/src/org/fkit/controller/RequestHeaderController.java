package org.fkit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;



/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */
@Controller
public class RequestHeaderController{
	
	// 测试@RequestHeader注解
	// 该方法映射的请求为 /requestHeaderTest
	@GetMapping(value="/requestHeaderTest")
	 public void requestHeaderTest(
			 @RequestHeader("User-Agent") String userAgent,  
		     @RequestHeader(value="Accept") String[] accepts) {
		 System.out.println("通过@requestHeaderTest获得User-Agent： " + userAgent);
		 System.out.println("通过@requestHeaderTest获得Accept： ");
		 // 循环输出头信息
		 for(String accept : accepts){
			 System.out.println(accept);
		 }
	 }

}

