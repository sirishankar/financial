package spsu.edu.financial.model;

// Generated Nov 10, 2013 7:28:52 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import framework.model.BaseObject;
import framework.security.User;

/**
 * Users generated by hbm2java
 */
public class Users extends BaseObject implements User{
	private static final long serialVersionUID = 5150880896979879403L;
	
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	private boolean allowDelete;
	private String auditCreateUser;
	private Date auditCeateDatetime;
	private String auditUpdateUser;
	private Date auditUpdateDatetime;


	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAuditCreateUser() {
		return this.auditCreateUser;
	}

	public void setAuditCreateUser(String auditCreateUser) {
		this.auditCreateUser = auditCreateUser;
	}

	public Date getAuditCeateDatetime() {
		return this.auditCeateDatetime;
	}

	public void setAuditCeateDatetime(Date auditCeateDatetime) {
		this.auditCeateDatetime = auditCeateDatetime;
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
	
	public String getUserName(){
		return firstName+" "+lastName;
	}

	@Override
	protected Long getPk() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAllowDelete() {
		return allowDelete;
	}

	public void setAllowDelete(boolean allowDelete) {
		this.allowDelete = allowDelete;
	}

}
