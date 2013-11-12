package framework.model;

import java.util.Date;

public abstract class BaseObject implements java.io.Serializable{
	protected String auditCreateUser;
	protected Date auditCreateDateTime;
	protected String auditUpdateUser;
	protected Date auditUpdateDateTime;

	protected Long version;

	protected abstract Long getPk();

	public boolean isNew() {
		return (this.getAuditCreateDateTime() == null);
	}
	public String getAuditCreateUser() {
		return auditCreateUser;
	}

	public void setAuditCreateUser(String auditCreateUser) {
		this.auditCreateUser = auditCreateUser;
	}

	public Date getAuditCreateDateTime() {
		return auditCreateDateTime;
	}

	public void setAuditCreateDateTime(Date auditCreateDateTime) {
		this.auditCreateDateTime = auditCreateDateTime;
	}

	public String getAuditUpdateUser() {
		return auditUpdateUser;
	}

	public void setAuditUpdateUser(String auditUpdateUser) {
		this.auditUpdateUser = auditUpdateUser;

	}

	public Date getAuditUpdateDateTime() {
		return auditUpdateDateTime;
	}

	public void setAuditUpdateDateTime(Date auditUpdateDateTime) {
		this.auditUpdateDateTime = auditUpdateDateTime;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
