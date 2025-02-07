package spring_blog.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import spring_blog.DTO.UserDTO;
import spring_blog.model.User;
import spring_blog.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean registerUser(UserDTO userDto) {
		User user = new User(
			null,
			userDto.getUsername(),
			userDto.getEmail(),
			userDto.getPassword(),
			LocalDateTime.now()
		);
		
		int rowsAffected = userRepository.create(user);
		return rowsAffected > 0;
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findByUsername(email);
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	
	public ArrayList<User> getUsers() {
		ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
		
		return users;
	}
	
	public boolean update(User user) {		
		int rowsAffected = userRepository.update(user);
		return rowsAffected > 0;
	}
	
	public boolean deleteById(Long id) {
		int rowsAffected = userRepository.deleteById(id);
		return rowsAffected > 0;
	}
}
