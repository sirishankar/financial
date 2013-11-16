package spsu.edu.financial.model;

// Generated Nov 15, 2013 11:54:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import framework.model.BaseObject;

/**
 * Resources generated by hbm2java
 */
public class Resources extends BaseObject {
	private static final long serialVersionUID = 5357700794097210459L;
	
	private Integer resourceId;
	private String category;
	private String description;
	private String auditCreateUser;
	private Date auditCreateDatetime;
	private String auditUpdateUser;
	private Date auditUpdateDatetime;

	public Resources() {
	}

	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuditCreateUser() {
		return this.auditCreateUser;
	}

	public void setAuditCreateUser(String auditCreateUser) {
		this.auditCreateUser = auditCreateUser;
	}

	public Date getAuditCreateDatetime() {
		return this.auditCreateDatetime;
	}

	public void setAuditCreateDatetime(Date auditCreateDatetime) {
		this.auditCreateDatetime = auditCreateDatetime;
	}

	public String getAuditUpdateUser() {
		return this.auditUpdateUser;
	}

	public void setAuditUpdateUser(String auditUpdateUser) {
		this.auditUpdateUser = auditUpdateUser;
	}

	public Date getAuditUpdateDatetime() {
		return this.auditUpdateDatetime;
	}

	public void setAuditUpdateDatetime(Date auditUpdateDatetime) {
		this.auditUpdateDatetime = auditUpdateDatetime;
	}

	@Override
	protected Long getPk() {
		// TODO Auto-generated method stub
		return null;
	}

}