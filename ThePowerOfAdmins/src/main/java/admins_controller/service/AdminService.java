package admins_controller.service;

import org.springframework.stereotype.Service;
import admins_controller.DTO.AdminDTO;
import admins_controller.model.Admin;
import admins_controller.repository.AdminRepository;

@Service
public class AdminService {
	private final AdminRepository aRepository;
	
	public AdminService(AdminRepository aRepository) {
		this.aRepository = aRepository;
	}
	
	public boolean registerAdmin(AdminDTO userDto) {
		Admin user = new Admin(
			null,
			userDto.getUsername(),
			userDto.getPassword()
		);
		
		int rowsAffected = aRepository.create(user);
		return rowsAffected > 0;
	}
	
	public Admin getAdminByUsername(String username) {
		return aRepository.findByUsername(username);
	}
	
	public Admin getAdminById(Long id) {
		return aRepository.findById(id);
	}
	
	public boolean deleteById(Long id) {
		int rowsAffected = aRepository.deleteById(id);
		return rowsAffected > 0;
	}
}
