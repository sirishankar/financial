package spsu.edu.financial.action;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;

import spsu.edu.financial.dao.UsersDao;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;

public class WelcomeAction extends BaseAction {
	private static final long serialVersionUID = -7918983290966872825L;
	
	private UsersDao usersDao;
	
	private String userId;
	private String password;
	
	public String execute(){
		String ret = "login";
		Users finUser = new Users();
		setErrorText("");
		if(StringUtils.isBlank(userId) && getUser()!=null){
			userId = getUser().getUserId();
		}

		if(StringUtils.isNotBlank(userId)){
			finUser = usersDao.getUser(userId);
			if(finUser!=null && StringUtils.isNotBlank(finUser.getUserId())){
				super.setUser(finUser);
				
				ret = SUCCESS;
			}
		}
		if(finUser == null || finUser.getUserId() == null){
			setErrorText("Invalid User or Password");
			ret = "login";			
		}
		return ret;
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
