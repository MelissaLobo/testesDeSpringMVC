package br.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	
	@RequestMapping("/home")
	public String execute(){
		System.out.println("Home");
		return "home";
	}

}
