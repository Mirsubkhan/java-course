package spring_blog.DTO;

public class UserDTO {
	private String username;
	private String email;
	private String password;
	
	public UserDTO(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public String getUsername() { return username; }
	public void setUsername(String value) { username = value; }
	
	public String getEmail() { return email; }
	public void setEmail(String value) { email = value; }
	
	public String getPassword() { return password; }
	public void setPassword(String value) { password = value; }
}
