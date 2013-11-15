package spsu.edu.financial.dao;

import java.util.List;

import spsu.edu.financial.model.Resources;
import framework.exceptions.ApplicationException;
import framework.model.BaseObject;

public interface ResourceDao {
	public BaseObject save(BaseObject object, String user) throws ApplicationException;
	public void saveOrUpdate(BaseObject object, String auditUser) throws ApplicationException;
	public  void delete(BaseObject object)  throws ApplicationException;
	
	public Resources getResource(Integer resourceId) ;
	public List<Resources> getAllResources();
}
