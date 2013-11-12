package spsu.edu.financial.dao;

import java.util.List;

import spsu.edu.financial.model.Users;


public interface UsersDao {
	
	public Users getUser(String userId);
	public List<Users> getAllUsers();
}
