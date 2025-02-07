package spring_blog.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

import spring_blog.DTO.PostDTO;
import spring_blog.model.Comment;
import spring_blog.model.User;
import spring_blog.service.PostService;
import spring_blog.service.UserService;

@Controller
public class PostController {
	private final PostService ps;
	private final UserService us;
	
	public PostController(PostService ps, UserService us) {
		this.ps = ps;
		this.us = us;
	}
	
	@GetMapping("/post/index")
	private String showPostPage(Model model, HttpSession session) {
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("posts", ps.getPosts());
		
		return "index";
	}
	
	@PostMapping("/post/quit")
	private String quitPage(HttpSession session) {		
		session.removeAttribute("username");
		
		return "login";
	}
	
	@GetMapping("/post/create")
	private String showCreatePostPage(HttpSession session, Model model) {
		model.addAttribute("username", session.getAttribute("username"));

		return "createPost";
	}
	
	@GetMapping("/post/settings")
	private String showSettingsPage(HttpSession session, Model model) {
		model.addAttribute("username", session.getAttribute("username"));

		return "settings";
	}
	
	@PostMapping("/post/create")
	private String createPost(@RequestParam String title, @RequestParam String content, Model model, HttpSession session) {
		String username = session.getAttribute("username").toString();
		
		if (!username.isBlank()) {
			User user = us.getUserByUsername(username);
			PostDTO postDto = new PostDTO(user, new ArrayList<Comment>(), title, content, java.time.LocalDateTime.now());
			
			ps.createPost(postDto);
			
			model.addAttribute("username", username);
			model.addAttribute("posts", ps.getPosts());
			
			return "index";
		}
		
		return "login/login";
	}
	
	
	@GetMapping("/post/error")
	private String Error(Model model) {
		return "Error";
	}
}
