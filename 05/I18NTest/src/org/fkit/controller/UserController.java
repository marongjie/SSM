package org.fkit.controller;



import javax.servlet.http.HttpServletRequest;
import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;


/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */


@Controller
public class UserController{
	 
	@RequestMapping(value="/loginForm")
	 public String loginForm(Model model){
		User user = new User();
		model.addAttribute("user",user);
		// 跳转页面
		return "loginForm";
	}
	 
	 @PostMapping(value="/login")
	 public String login(
			 @ModelAttribute User user,
			 Model model,
			 HttpServletRequest request) {
		 System.out.println(user);
		 // 如果登录名是fkit，密码是123456，则验证通过
		 if(user.getLoginname()!=null && user.getLoginname().equals("fkit")
			 && user.getPassword()!=null && user.getPassword().equals("123456")){
			 //从后台代码获取国际化信息username
	         RequestContext requestContext = new RequestContext(request);
	         String username = requestContext.getMessage("username");
	         // 将获取的username信息设置到User对象并设置到Model当中
	         user.setUsername(username);
			 model.addAttribute("user", user);
		     return "success";
		 }
		 return "error";
		
	 }

}

