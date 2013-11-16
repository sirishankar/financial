package spsu.edu.financial.action;

import java.util.List;

import spsu.edu.financial.dao.ProjectDao;
import spsu.edu.financial.dao.UsersDao;
import spsu.edu.financial.model.Projects;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class AddProjectAction extends BaseAction {

	private static final long serialVersionUID = -6319316278232974156L;
	private Projects project;
	private Users finUser;
	private List<Users> userList;
	private ProjectDao projectDao;
	private UsersDao usersDao;
	
	public String execute(){
		project = new Projects();
		userList = usersDao.getAllUsers();
		
		return SUCCESS;
	}
	
	public String save() throws ApplicationException{
		finUser = (Users) getUser();
		if(project!=null){
			projectDao.save(project, finUser.getUserId());
		}
		return "viewProjects";
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
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


}
