package spsu.edu.financial.dao;

import java.util.List;

import framework.exceptions.ApplicationException;
import framework.model.BaseObject;
import spsu.edu.financial.model.Users;


public interface UsersDao {
	public BaseObject save(BaseObject object, String user) throws ApplicationException;
	public void saveOrUpdate(BaseObject object, String auditUser) throws ApplicationException;
	public  void delete(BaseObject object)  throws ApplicationException;
	
	public Users getUser(String userId);
	public List<Users> getAllUsers();
}
