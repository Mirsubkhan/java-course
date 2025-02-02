package spring_blog.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring_blog.model.User;

@Repository
public class UserRepositoryTmpl implements UserRepository {
	private final JdbcTemplate jdbcTemplate;
	
	public UserRepositoryTmpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<User> findAll() {
		String query = "SELECT * FROM users";
		
		return jdbcTemplate.query(query, (rs, rowNum) -> getUser(rs));
	}

	@Override
	public User findById(Long id) {
		String query = "SELECT * FROM users WHERE id = (?)";

	    return jdbcTemplate.queryForObject(query, (rs, rowNum) -> getUser(rs), id);
	}
	
	@Override
	public User findByUsername(String username) {
	    String query = "SELECT * FROM users WHERE username = (?)";
	    
	    try {
	        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> getUser(rs), username);
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}
	
	@Override
	public User findByEmail(String email) {
	    String query = "SELECT * FROM users WHERE email = (?)";
	    
	    try {
	        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> getUser(rs), email);
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}

	@Override
	public int create(User user) {
		String query = "INSERT INTO users (username, email, password) VALUES(?, ?, ?)";
		Object[] args = new Object[] {user.getUsername(), user.getEmail(), user.getPassword()};
		
		return jdbcTemplate.update(query, args);
	}

	@Override
	public int update(User user) {
		String query = "UPDATE users SET email = (?), username = (?) WHERE id = (?)";
		Object[] args = new Object[] {user.getEmail(), user.getUsername(), user.getId()};
		
		return jdbcTemplate.update(query, args);
	}

	@Override
	public int deleteById(Long id) {
		String query = "DELETE FROM users WHERE id = (?)";
		
		return jdbcTemplate.update(query, id);
	}

	private User getUser(ResultSet rs) {
		try {
			return new User(
				rs.getLong("id"),
				rs.getString("username"),
				rs.getString("email"),
				rs.getString("password"),
				rs.getTimestamp("created_at").toLocalDateTime()
			);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
