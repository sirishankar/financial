package spsu.edu.financial.action;

import java.util.List;

import spsu.edu.financial.dao.ResourceDao;
import spsu.edu.financial.model.Resources;
import framework.action.BaseAction;

public class ViewResourceAction extends BaseAction {
	private static final long serialVersionUID = -7824672513730578069L;
	private List<Resources> resourceList;
	
	private ResourceDao resourceDao;
	public String execute(){
		
		return SUCCESS;
	}
	
	public String getJSON(){
		resourceList = resourceDao.getAllResources();
		
		return SUCCESS;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public List<Resources> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resources> resourceList) {
		this.resourceList = resourceList;
	}


}
