package admins_controller.repository;

import admins_controller.model.Admin;

public interface AdminRepository {
	Admin findById(Long id);
	Admin findByUsername(String username);
	int create (Admin user);
	int deleteById(Long id);
}
