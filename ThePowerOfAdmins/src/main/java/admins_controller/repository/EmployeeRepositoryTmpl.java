package admins_controller.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import admins_controller.model.Employee;

@Repository
public class EmployeeRepositoryTmpl implements EmployeeRepository {
	private final JdbcTemplate jdbcTemplate;
	
	public EmployeeRepositoryTmpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Employee> findAll() {
		String query = "SELECT * FROM employees";
		
		try {
	        return jdbcTemplate.query(query, (rs, rowNum) -> getEmployee(rs));
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}

	@Override
	public Employee findById(Long id) {
		String query = "SELECT * FROM employees WHERE id = (?)";


		try {
	        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> getEmployee(rs), id);
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}
	
	@Override
	public List<Employee> findByJobTitle(String jobTitle) {
	    String query = "SELECT * FROM employees WHERE job_title = (?)";
	    
	    try {
	        return jdbcTemplate.query(query, (rs, rowNum) -> getEmployee(rs), jobTitle);
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}

	@Override
	public int deleteById(Long id) {
		String query = "DELETE FROM employees WHERE id = (?)";
		
		return jdbcTemplate.update(query, id);
	}

	private Employee getEmployee(ResultSet rs) {
		try {
			return new Employee(
				rs.getLong("id"),
				rs.getString("full_name"),
				rs.getString("job_title"),
				rs.getString("address"),
				rs.getInt("salary")
			);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
