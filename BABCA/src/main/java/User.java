
public class User {
	private int id;
	private String login;
	private String email;
	
	public User(int id, String login, String email) {
		this.id = id;
		this.login = login;
		this.email = email;
	}
	
	public int getId() {return id;}
	public String getLogin() {return login;}
	public String getEmail() {return email;}
	
	public void setId(int v){id = v;}
	public void setLogin(String v) { login = v;}
	public void setEmail(String v) {email = v;}
}
