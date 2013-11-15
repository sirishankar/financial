package spsu.edu.financial.action;

import spsu.edu.financial.dao.UsersDao;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class EditUserAction extends BaseAction {
	private static final long serialVersionUID = -7928496162796490623L;
	
	private String userId;
	private Users finUser;
	private UsersDao usersDao;
	
	public String execute(){
		if(userId!=null){
			finUser = usersDao.getUser(userId);
		}else{
			this.addActionError("Invalud User. ");
		}
		return SUCCESS;
	}

	public String save() throws ApplicationException{
		usersDao.saveOrUpdate(finUser, finUser.getUserId());

		return "viewUsers";
	}
	public String delete() throws ApplicationException {
		if(userId!=null){
			finUser = usersDao.getUser(userId);
			usersDao.delete(finUser);
		}else{
			this.addActionError("Invalud User. ");
		}
		
		return "viewUsers";
	}
	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public Users getFinUser() {
		return finUser;
	}

	public void setFinUser(Users finUser) {
		this.finUser = finUser;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
