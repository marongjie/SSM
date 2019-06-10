package org.fkit.controller;


import org.fkjava.exception.BookException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController{
	
	@GetMapping("/find")
	public String find() throws Exception{
		try {
			int i = 5/0;
			return "success";
		} catch (Exception e) {
			throw new BookException();
		}
		
		
	}

}
