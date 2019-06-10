package org.fkit.controller;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.User;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
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
	 public String loginForm(
			 String request_locale,
			 Model model,
			 HttpServletRequest request,
			 HttpServletResponse response){
		System.out.println("request_locale = " + request_locale);
		if(request_locale != null){
			if(request_locale.equals("zh_CN")){
				Locale locale = new Locale("zh", "CN"); 
				(new CookieLocaleResolver()).setLocale (request, response, locale);
			}
			else if(request_locale.equals("en_US")){
				Locale locale = new Locale("en", "US"); 
				(new CookieLocaleResolver()).setLocale (request, response, locale);
			}else {
				(new CookieLocaleResolver()).setLocale (request, response, LocaleContextHolder.getLocale());
			}      
		}
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
//		 System.out.println(user);
		 if(user.getLoginname()!=null && user.getLoginname().equals("fkit")
			 && user.getPassword()!=null && user.getPassword().equals("123456")){
			 //从后台代码获取国际化信息
	         RequestContext requestContext = new RequestContext(request);
	         String username = requestContext.getMessage("username");
	         user.setUsername(username);
			 model.addAttribute("user", user);
		     return "success";
		 }
		 return "error";
		
	 }

}

