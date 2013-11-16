package spsu.edu.financial.action;

import java.util.List;

import spsu.edu.financial.dao.ProjectDao;
import spsu.edu.financial.dao.UsersDao;
import spsu.edu.financial.model.Projects;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class EditProjectAction extends BaseAction {
	private static final long serialVersionUID = -8454776749457454213L;
	private ProjectDao projectDao;
	private UsersDao usersDao;	
	private Projects project;
	private Integer projectId;
	private List<Users> userList;
	
	public String execute(){
		if(projectId!=null){
			userList = usersDao.getAllUsers();
			project = projectDao.getProject(projectId);
		}else{
			this.addActionError("Invalud Resource.");
		}
		return SUCCESS;
	}

	public String save() throws ApplicationException{
		Users finUser = (Users) getUser();
		projectDao.saveOrUpdate(project, finUser.getUserId());

		return "viewProjects";
	}
	public String delete() throws ApplicationException {
		if(projectId!=null){
			project = projectDao.getProject(projectId);
			projectDao.delete(project);
		}else{
			this.addActionError("Invalud Project. ");
		}
		
		return "viewProjects";
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}


}
