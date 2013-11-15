package spsu.edu.financial.dao;

import java.util.List;

import spsu.edu.financial.model.Resources;
import framework.dao.BaseDAO;

public class ResourceDaoImpl extends BaseDAO implements ResourceDao {

	@Override
	public Resources getResource(Integer resourceId) {
		Resources resources = (Resources) this.getHibernateTemplate().get(Resources.class, resourceId);
		
		return resources;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resources> getAllResources() {
		List<Resources> allResources = this.getHibernateTemplate().findByNamedQuery("getAllResources");
		
		return allResources;
	}

}
