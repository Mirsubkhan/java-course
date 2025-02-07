package admins_controller.repository;
import java.util.List;

import admins_controller.model.Employee;

public interface EmployeeRepository {
	List<Employee> findAll();
	Employee findById(Long id);
	List<Employee> findByJobTitle(String jobTitle);
	int deleteById(Long id);
}
