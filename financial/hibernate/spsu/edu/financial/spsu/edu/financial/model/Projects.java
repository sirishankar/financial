package spsu.edu.financial.model;

// Generated Nov 15, 2013 5:46:12 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * Projects generated by hbm2java
 */
public class Projects implements java.io.Serializable {

	private Integer projectId;
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

	public Projects() {
	}

	public Projects(String status) {
		this.status = status;
	}

	public Projects(String projectName, String description, String status,
			Date startDate, Date endDate, BigDecimal projectedCost,
			BigDecimal actualCost, String comments, String clientName,
			String clientEmail, String managerId) {
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

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
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

}
