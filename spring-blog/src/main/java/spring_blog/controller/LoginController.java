package spring_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

import spring_blog.service.PostService;
import spring_blog.service.UserService;


@Controller
public class LoginController {
	private final UserService us;
	private final PostService ps;
	
	public LoginController(UserService us, PostService ps) {
		this.us = us;
		this.ps = ps;
	}
	
	@GetMapping("/login/login")
	private String showLoginPage(Model model) {
		return "login";
	}
	
	@PostMapping("/login/login")
	private String loginUser(@RequestParam String username, 
			@RequestParam String password, 
			Model model, HttpSession session) {
		
		if (us.getUserByUsername(username) != null && 
				us.getUserByUsername(username).getPassword().equals(password)) {
			session.setAttribute("username", username);
			model.addAttribute("username", username);
			
	        if (username.toLowerCase().equals("admin")) {
	    		model.addAttribute("users", us.getUsers());
	    		
	        	return "admin";
	        }
	        else {
				model.addAttribute("posts", ps.getPosts());

	        	return "index";
	        }
	    }
		
		String message = "Mention: The username or password is incorrect!";
		model.addAttribute("message", message);
		
		return "login";
	}
	
	@GetMapping("/login/error")
	private String Error(Model model) {
		return "Error";
	}
}
