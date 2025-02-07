package admins_controller.DTO;

public class EmployeeDTO {
	private String fullName;
	private String address;
	private String jobTitle;
	private int salary;
	
	public EmployeeDTO(String fullName, String jobTitle, String address, int salary) {
	    this.fullName = fullName;
	    this.jobTitle = jobTitle;
	    this.setAddress(address);
	    this.setSalary(salary);
	}
	
	public String getFullName() { return fullName; }
	public void setFullName(String fullName) { this.fullName = fullName; }
	
	public String getJobTitle() { return jobTitle; }
	public void setJobTitle(String email) { this.jobTitle = email; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
}
