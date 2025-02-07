package admins_controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admins_controller.DTO.AdminDTO;
import admins_controller.service.AdminService;

import org.springframework.ui.Model;

@Controller
public class AuthController {
	private final AdminService as;
	
	public AuthController(AdminService as) {
        this.as = as;
    }
	
	@GetMapping("/auth/register")
	private String showRegistrationPage(Model model) {
		return "register";
	}
	
	@PostMapping("/auth/register")
	private String registerAdmin(@RequestParam String username, 
								@RequestParam String password, 
								@RequestParam String password2,
								Model model) {
				
		if(as.getAdminByUsername(username) != null) {
			String message = "Mention: This account is already exist!";
			model.addAttribute("message", message);
			
			return "register";
		}
		
		if (!password.equals(password2)) {
			String message = "Mention: The password is incorrect!";
			model.addAttribute("message", message);
			
			return "register";
		}
		
		AdminDTO admin = new AdminDTO(username, password);
		as.registerAdmin(admin);
		
		return "login";
	}
	
	@GetMapping("/auth/error")
	private String Error(Model model) {
		return "error";
	}
}
