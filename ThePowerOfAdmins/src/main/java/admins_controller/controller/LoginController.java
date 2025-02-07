package admins_controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admins_controller.service.AdminService;
import admins_controller.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@Controller
public class LoginController {
	private final AdminService as;
	private final EmployeeService es;
	
	public LoginController(AdminService as, EmployeeService es) {
		this.as = as;
		this.es = es;
	}
	
	@GetMapping("/login/login")
	private String showLoginPage(Model model) {
		return "login";
	}
	
	@PostMapping("/login/login")
	private String loginUser(@RequestParam String username, 
							@RequestParam String password, 
							Model model, HttpSession session) {
		
		if (as.getAdminByUsername(username) != null && 
				as.getAdminByUsername(username).getPassword().equals(password)) {
			session.setAttribute("username", username);
			model.addAttribute("username", username);
			model.addAttribute("employees", es.getEmployees());

	        return "admin";
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
