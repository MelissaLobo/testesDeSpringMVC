package br.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

	@RequestMapping("/index")
	public String execute(){
		System.out.println("Teste Spring MVC");
		return "index";
	}
}
