package framework.dao;

import java.util.Calendar;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framework.exceptions.ApplicationException;
import framework.model.BaseObject;

public class BaseDAO extends HibernateDaoSupport {

	public BaseObject save(BaseObject object, String user) throws ApplicationException {
		try {
			setAuditInfo(object, user);
			this.getHibernateTemplate().save(object);
			return object;
		} catch (Exception e) {
			throw new ApplicationException("Unable to save {0}", e, object.getClass().getName());
		}
	}

	public void saveOrUpdate(BaseObject object, String user) throws ApplicationException {
		try {
			setAuditInfo(object, user);
			this.getHibernateTemplate().saveOrUpdate(object);
		} catch (Exception e) {
			throw new ApplicationException("Unable to save {0}", e, object.getClass().getName());
		}
	}
	
	public  void delete(BaseObject object)  throws ApplicationException {
		try{
		this.getHibernateTemplate().delete(object);
		}catch (Exception e){
			throw new ApplicationException("Unable to delete {0}", e, object.getClass().getName()); 
		}
	}
	private void setAuditInfo(BaseObject object, String user) {
		if (object.isNew()) {
			object.setAuditCreateDateTime(Calendar.getInstance().getTime());
			object.setAuditCreateUser(user);
		}
		object.setAuditUpdateDateTime(Calendar.getInstance().getTime());
		object.setAuditUpdateUser(user);
	}
}
