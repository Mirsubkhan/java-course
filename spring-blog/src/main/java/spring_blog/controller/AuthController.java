package spring_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import spring_blog.DTO.UserDTO;
import spring_blog.service.UserService;

@Controller
public class AuthController {
	private final UserService us;
	
	public AuthController(UserService us) {
        this.us = us;
    }
	
	@GetMapping("/auth/register")
	private String showRegistrationPage(Model model) {
		return "register";
	}
	
	@PostMapping("/auth/register")
	private String registerUser(@RequestParam String username, 
			@RequestParam String email,
			@RequestParam String password, 
			Model model) {
				
		if(us.getUserByUsername(username) != null) {
			String message = "Mention: This account is already exist!";
			model.addAttribute("message", message);
			
			return "register";
		}
		
		UserDTO user = new UserDTO(username, email, password);
		us.registerUser(user);
		
		return "login";
	}
	
	@GetMapping("/auth/error")
	private String Error(Model model) {
		return "error";
	}
}
