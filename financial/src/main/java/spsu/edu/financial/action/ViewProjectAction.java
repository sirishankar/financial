package spsu.edu.financial.action;

import java.util.List;

import spsu.edu.financial.dao.ProjectDao;
import spsu.edu.financial.model.Projects;
import framework.action.BaseAction;

public class ViewProjectAction extends BaseAction {
	private static final long serialVersionUID = -3713213171180403398L;

	private List<Projects> projectList;
	
	private ProjectDao projectDao;
	public String execute(){
		
		return SUCCESS;
	}
	
	public String getJSON(){
		projectList = projectDao.getAllProjects();
		
		return SUCCESS;
	}


	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public List<Projects> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Projects> projectList) {
		this.projectList = projectList;
	}
    
/*  
<sjg:gridColumn name="startDate" index="startDate" title="Start Date" sortable="false" 
formatter="date" formatoptions="{newformat : 'm/d/y', srcformat : 'Y-m-d H:i:s'}"
 width="80"/>
<sjg:gridColumn name="endDate" index="endDate" title="End Date" sortable="false" 
formatter="date" formatoptions="{newformat : 'm/d/y', srcformat : 'Y-m-d H:i:s'}"
 width="80"/> 
 */	

}
