package spring_blog.repository;
import java.util.List;

import spring_blog.model.User;

public interface UserRepository {
	List<User> findAll();
	User findById(Long id);
	User findByUsername(String username);
	User findByEmail(String email);
	int create (User user);
	int update (User user);
	int deleteById(Long id);
}
