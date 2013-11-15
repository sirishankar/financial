package spsu.edu.financial.action;

import java.util.List;

import spsu.edu.financial.dao.ProjectDao;
import spsu.edu.financial.model.Projects;
import framework.action.BaseAction;

public class ViewProjectAction extends BaseAction {
	private static final long serialVersionUID = -3713213171180403398L;

	private List<Projects> proecteList;
	
	private ProjectDao projectDao;
	public String execute(){
		
		return SUCCESS;
	}
	
	public String getJSON(){
		proecteList = projectDao.getAllProjects();
		
		return SUCCESS;
	}

	public List<Projects> getProecteList() {
		return proecteList;
	}

	public void setProecteList(List<Projects> proecteList) {
		this.proecteList = proecteList;
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

}
