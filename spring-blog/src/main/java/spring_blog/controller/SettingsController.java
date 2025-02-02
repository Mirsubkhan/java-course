package spring_blog.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

import spring_blog.model.Post;
import spring_blog.model.User;
import spring_blog.service.CommentService;
import spring_blog.service.PostService;
import spring_blog.service.UserService;


@Controller
public class SettingsController {
	private final UserService us;
	private final PostService ps;
	private final CommentService cs;
	
	public SettingsController(UserService us, PostService ps, CommentService cs) {
		this.us = us;
		this.ps = ps;
		this.cs = cs;
	}
	
	@GetMapping("/settings/settings")
	private String showSettingsPage(Model model, HttpSession session) {
		model.addAttribute("username", session.getAttribute("username"));

		return "settings";
	}
	
	@PostMapping("/settings/edit")
	private String editUser(@RequestParam String username, 
			@RequestParam String email, 
			Model model, HttpSession session) {
		
		User user; 
		
		if(!email.isBlank()) {
			user = us.getUserByEmail(email);
		}
		else {
			user = us.getUserByUsername(username);
		}
		
		if (user == null) {
			String oldUsername = session.getAttribute("username").toString();
			
			User newUser = us.getUserByUsername(oldUsername);
			
			newUser.setUsername(username);
			
			if(!email.isBlank()) {
				newUser.setEmail(email);
			}
			
			us.update(newUser);
			session.setAttribute("username", username);
			model.addAttribute("posts", ps.getPosts());
			model.addAttribute("username", username);
			
	        return "index";
	    }
		
		String message = "Mention: The username or email is taken!";
		model.addAttribute("message", message);
		
		return "login";
	}
	
	@PostMapping("/settings/delete")
	private String deleteUser(Model model, HttpSession session) {
		
		User user = us.getUserByUsername(session.getAttribute("username").toString());
		
		ArrayList<Post> posts = (ArrayList<Post>) ps.getPostByAuthorId(user.getId());
		
		for(Post p : posts) {
			cs.deleteById(p.getId());
		}
		
		ps.deleteById(user.getId());
		
		us.deleteById(user.getId());
			
	    return "login";
	}
	
	@GetMapping("/settings/error")
	private String Error(Model model) {
		return "Error";
	}
}
