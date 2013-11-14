package spsu.edu.financial.dao;

import java.util.List;

import spsu.edu.financial.model.Users;
import framework.dao.BaseDAO;
import framework.exceptions.ApplicationException;

public class UsersDaoImpl extends BaseDAO implements UsersDao {

	public Users getUser(String userId){
		
		Users user = (Users) this.getHibernateTemplate().get(Users.class, userId);
		
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers(){
		List<Users> allUsers = this.getHibernateTemplate().findByNamedQuery("getAllUsers");
		
		return allUsers;
	}

}
