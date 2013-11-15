package spsu.edu.financial.action;

import spsu.edu.financial.dao.ResourceDao;
import spsu.edu.financial.model.Resources;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class AddResourceAction extends BaseAction {
	private static final long serialVersionUID = 922186595447052488L;
	
	private Resources resource;
	private Users finUser;
	private ResourceDao resourceDao;
	
	public String execute(){
		resource = new Resources();
		
		return SUCCESS;
	}
	
	public String save() throws ApplicationException{
		finUser = (Users) getUser();
		if(resource!=null){
			resourceDao.save(resource, finUser.getUserId());
		}
		return "viewResources";
	}

	public Users getFinUser() {
		return finUser;
	}	
	

	public Resources getResource() {
		return resource;
	}

	public void setResource(Resources resource) {
		this.resource = resource;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public void setFinUser(Users finUser) {
		this.finUser = finUser;
	}

}
