package spsu.edu.financial.dao;

import java.util.List;

import spsu.edu.financial.model.Projects;
import framework.dao.BaseDAO;

public class ProjectDaoImpl extends BaseDAO implements ProjectDao {

	@Override
	public Projects getProject(Integer projectId){
		Projects project = (Projects) this.getHibernateTemplate().get(Projects.class, projectId);
		
		return project;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projects> getAllProjects() {
		List<Projects> allProjects = this.getHibernateTemplate().findByNamedQuery("getAllProjects");
		
		return allProjects;
	}

}
