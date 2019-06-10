package org.fkit.controller;

import java.util.ArrayList;
import java.util.List;
import org.fkit.domain.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */
/**
 * @RestController注解使用@Controller和@ResponseBody注解。
 * 使用了@RestController注解的类会被看作一个controller，
 * 使用@RequestMapping的方法有一个默认的@ResponseBody注解。
 * */
@RestController
@RequestMapping("/json")
public class BookController {
	
	
    @RequestMapping(value="/testRequestBody")
    public Object getJson() {
    	List<Book> list = new ArrayList<Book>();
    	list.add(new Book(1,"Spring+MyBatis企业应用实战","肖文吉"));
    	list.add(new Book(2,"轻量级JavaEE企业应用实战","李刚"));
    	return list;
    }

}
