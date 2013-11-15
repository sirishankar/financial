package spsu.edu.financial.action;

import spsu.edu.financial.dao.ProjectDao;
import spsu.edu.financial.model.Projects;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class AddProjectAction extends BaseAction {

	private static final long serialVersionUID = -6319316278232974156L;
	private Projects project;
	private Users finUser;
	private ProjectDao projectDao;
	
	public String execute(){
		project = new Projects();
		
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


}
