package spsu.edu.financial.model;

// Generated Nov 15, 2013 11:54:57 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import framework.model.BaseObject;

/**
 * Projects generated by hbm2java
 */
public class Projects extends BaseObject {
	private static final long serialVersionUID = 6032056250764705705L;
	
	private String projectId;
	private String projectName;
	private String description;
	private String status;
	private Date startDate;
	private Date endDate;
	private BigDecimal projectedCost;
	private BigDecimal actualCost;
	private String comments;
	private String clientName;
	private String clientEmail;
	private String managerId;
	private Users user;

	public Projects() {
	}

	public Projects(String projectId, String status) {
		this.projectId = projectId;
		this.status = status;
	}

	public Projects(String projectId, String projectName, String description,
			String status, Date startDate, Date endDate,
			BigDecimal projectedCost, BigDecimal actualCost, String comments,
			String clientName, String clientEmail, String managerId) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectedCost = projectedCost;
		this.actualCost = actualCost;
		this.comments = comments;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.managerId = managerId;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getProjectedCost() {
		return this.projectedCost;
	}

	public void setProjectedCost(BigDecimal projectedCost) {
		this.projectedCost = projectedCost;
	}

	public BigDecimal getActualCost() {
		return this.actualCost;
	}

	public void setActualCost(BigDecimal actualCost) {
		this.actualCost = actualCost;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return this.clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getManagerId() {
		return this.managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	@Override
	protected Long getPk() {
		// TODO Auto-generated method stub
		return null;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
