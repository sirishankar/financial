package spsu.edu.financial.action;

import java.util.ArrayList;
import java.util.List;

import spsu.edu.financial.dao.UsersDao;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;

public class ViewUsersAction extends BaseAction {
	private static final long serialVersionUID = -1517254290066711329L;

	private UsersDao usersDao;
	private List<Users> usersList = new ArrayList<Users>();
	
	public String execute(){
		
		return SUCCESS;
	}
	
	public String getJSON(){
		usersList = usersDao.getAllUsers();
		
		return SUCCESS;
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public List<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}

}
