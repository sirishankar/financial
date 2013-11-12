package framework.security;

public interface User {
	public String getUserId();
	public void setUserId(String userId);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getPassword();
	public void setPassword(String password);
	public String getRole();
	public void setRole(String role);
	public String getEmail();
	public void setEmail(String email);	
}
