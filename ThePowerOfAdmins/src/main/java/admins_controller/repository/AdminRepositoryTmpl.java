package admins_controller.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import admins_controller.model.Admin;

@Repository
public class AdminRepositoryTmpl implements AdminRepository {
	private final JdbcTemplate jdbcTemplate;
	
	public AdminRepositoryTmpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Admin findById(Long id) {
		String query = "SELECT * FROM admins WHERE id = (?)";

	    return jdbcTemplate.queryForObject(query, (rs, rowNum) -> getAdmin(rs), id);
	}
	
	@Override
	public Admin findByUsername(String username) {
	    String query = "SELECT * FROM admins WHERE username = (?)";
	    
	    try {
	        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> getAdmin(rs), username);
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}

	@Override
	public int create(Admin admin) {
		String query = "INSERT INTO admins (username, password) VALUES(?, ?)";
		Object[] args = new Object[] {admin.getUsername(), admin.getPassword()};
		
		return jdbcTemplate.update(query, args);
	}

	@Override
	public int deleteById(Long id) {
		String query = "DELETE FROM admins WHERE id = (?)";
		
		return jdbcTemplate.update(query, id);
	}

	private Admin getAdmin(ResultSet rs) {
		try {
			return new Admin(
				rs.getLong("id"),
				rs.getString("username"),
				rs.getString("password")
			);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
