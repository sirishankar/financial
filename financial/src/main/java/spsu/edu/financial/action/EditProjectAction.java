package spsu.edu.financial.action;

import spsu.edu.financial.dao.ProjectDao;
import spsu.edu.financial.model.Projects;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class EditProjectAction extends BaseAction {
	private static final long serialVersionUID = -8454776749457454213L;
	private ProjectDao projectDao;
	private Projects project;
	private Integer projectId;
	
	public String execute(){
		if(projectId!=null){
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
			this.addActionError("Invalud User. ");
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


}
