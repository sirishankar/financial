package spsu.edu.financial.action;

import spsu.edu.financial.dao.UsersDao;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class AddUserAction extends BaseAction {
	private static final long serialVersionUID = 8772831152063875478L;
	
	private Users finUser;
	private UsersDao usersDao;
	
	public String execute(){
		finUser = new Users();
		
		return SUCCESS;
	}
	
	public String save() throws ApplicationException{
		if(finUser!=null){
			usersDao.save(finUser, finUser.getUserId());
		}
		return "viewUsers";
	}

	public Users getFinUser() {
		return finUser;
	}

	public void setFinUser(Users finUser) {
		this.finUser = finUser;
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

}
