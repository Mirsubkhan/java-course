package admins_controller.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import admins_controller.model.Employee;
import admins_controller.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository eRepository;
	
	public EmployeeService(EmployeeRepository eRepository) {
		this.eRepository = eRepository;
	}
	
	public ArrayList<Employee> getEmployeesByJobTitle(String jobTitle) {
		return (ArrayList<Employee>) eRepository.findByJobTitle(jobTitle);
	}
	
	public Employee getEmployeeById(Long id) {
		ArrayList<Employee> ems = (ArrayList<Employee>) eRepository.findAll();
		
		if(ems == null) {
			System.out.println("is null");
		}
		
		else if (ems.isEmpty()){
			System.out.println("is empty");
		}
		else {
			System.out.println(eRepository.findAll().get(0).getId());
		}
		return eRepository.findById(id);
	}
	
	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employees = (ArrayList<Employee>) eRepository.findAll();
		
		return employees;
	}
	
	public boolean deleteById(Long id) {
		int rowsAffected = eRepository.deleteById(id);
		return rowsAffected > 0;
	}
}
