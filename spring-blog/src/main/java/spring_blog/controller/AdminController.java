package spring_blog.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

import spring_blog.model.Post;
import spring_blog.model.User;
import spring_blog.service.CommentService;
import spring_blog.service.PostService;
import spring_blog.service.UserService;


@Controller
public class AdminController {
	private final UserService us;
	private final PostService ps;
	private final CommentService cs;
	
	public AdminController(UserService us, PostService ps, CommentService cs) {
		this.us = us;
		this.ps = ps;
		this.cs = cs;
	}
	
	@GetMapping("/admin/admin")
	private String showAdminPage(Model model, HttpSession session) {
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("users", us.getUsers());

		return "admin";
	}
	
	@GetMapping("/admin/quit")
	private String quitAdminPage(Model model, HttpSession session) {
		session.removeAttribute("username");
		
		return "login";
	}
	
	@PostMapping("/admin/delete/{uid}")
	private String deleteUser(@PathVariable Long uid, Model model, HttpSession session) {
		User user = us.getUserById(uid); 
		
		if (user != null) {
	        ArrayList<Post> posts = (ArrayList<Post>) ps.getPostByAuthorId(user.getId());
	        for (Post p : posts) {
	            cs.deleteById(p.getId());
	        }

	        ps.deleteById(user.getId());
	        us.deleteById(user.getId());
	        model.addAttribute("username", session.getAttribute("username"));
			model.addAttribute("users", us.getUsers());
	        
	        model.addAttribute("message", "User deleted successfully");
	    } else {
	        model.addAttribute("message", "User not found!");
	    }

	    return "admin";
	}
	
	@GetMapping("/admin/error")
	private String Error(Model model) {
		return "Error";
	}
}
