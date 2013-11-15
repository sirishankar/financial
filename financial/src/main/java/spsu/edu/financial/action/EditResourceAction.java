package spsu.edu.financial.action;

import spsu.edu.financial.dao.ResourceDao;
import spsu.edu.financial.model.Resources;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class EditResourceAction extends BaseAction {
	private static final long serialVersionUID = 2966859734721480431L;
	private ResourceDao resourceDao;
	private Resources resource;
	private Integer resourceId;
	
	public String execute(){
		if(resourceId!=null){
			resource = resourceDao.getResource(resourceId);
		}else{
			this.addActionError("Invalud Resource.");
		}
		return SUCCESS;
	}

	public String save() throws ApplicationException{
		Users finUser = (Users) getUser();
		resourceDao.saveOrUpdate(resource, finUser.getUserId());

		return "viewResources";
	}
	public String delete() throws ApplicationException {
		if(resourceId!=null){
			resource = resourceDao.getResource(resourceId);
			resourceDao.delete(resource);
		}else{
			this.addActionError("Invalud User. ");
		}
		
		return "viewResources";
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public Resources getResource() {
		return resource;
	}

	public void setResource(Resources resource) {
		this.resource = resource;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

}
