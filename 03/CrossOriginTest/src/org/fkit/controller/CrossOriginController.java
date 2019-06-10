package org.fkit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */
@CrossOrigin(maxAge=3600)
@Controller
public class CrossOriginController{

	// 测试@CrossOrigin注解
	@CrossOrigin(origins="http://localhost:8080/VariableTest")
	@GetMapping(value="/welcome")
	 public String welcome() {
		 System.out.println("处理跨域请求");
		 return "welcome";
	 }
	
}

