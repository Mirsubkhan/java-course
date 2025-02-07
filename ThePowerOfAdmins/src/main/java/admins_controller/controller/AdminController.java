package admins_controller.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admins_controller.model.Employee;
import admins_controller.service.AdminService;
import admins_controller.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@Controller
public class AdminController {
	private final AdminService as;
	private final EmployeeService es;
	
	public AdminController(AdminService as, EmployeeService es) {
		this.as = as;
		this.es = es;
	}
	
	@GetMapping("/admin/admin")
	private String showAdminPage(Model model, HttpSession session) {
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("employees", es.getEmployees());

		return "admin";
	}
	
	@GetMapping("/admin/quit")
	private String quitAdminPage(Model model, HttpSession session) {
		session.removeAttribute("username");
		
		return "login";
	}
	
	@GetMapping("/admin/fireAdmin")
	private String deleteAdmin(@RequestParam String username, Model model, HttpSession session) {
		as.deleteById(as.getAdminByUsername(username).getId());
		session.removeAttribute("username");
		
		return "login";
	}
	
	@PostMapping("/admin/fireEmployee")
	private String deleteEmployee(@RequestParam Long uid, Model model, HttpSession session) {
        model.addAttribute("username", session.getAttribute("username"));

	    if(es.getEmployeeById(uid) != null) {
	        es.deleteById(uid);
		    model.addAttribute("message", "The employee fired successfully");
	    }
	    
	    else {
		    model.addAttribute("message", "The employee not found");
	    }
	    
	    model.addAttribute("employees", es.getEmployees());

	    return "admin";
	}
	
	@GetMapping("/admin/filter")
	private String filterByJobTitle(@RequestParam String filter, Model model, HttpSession session) {
			ArrayList<Employee> employees = es.getEmployeesByJobTitle(filter);
			model.addAttribute("username", session.getAttribute("username"));
			
	        if(employees != null && !employees.isEmpty()) {
				model.addAttribute("employees", employees);
			}
	        else {
	        	model.addAttribute("username", session.getAttribute("username"));
	        	model.addAttribute("employees", es.getEmployees());
		        model.addAttribute("message", "Employees with this filter not found");
	        }
	    return "admin";
	}
	
	@GetMapping("/admin/error")
	private String Error(Model model) {
		return "Error";
	}
}
