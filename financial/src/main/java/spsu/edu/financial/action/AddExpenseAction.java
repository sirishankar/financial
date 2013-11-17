package spsu.edu.financial.action;

import java.util.List;

import spsu.edu.financial.dao.ExpenseDao;
import spsu.edu.financial.dao.ProjectDao;
import spsu.edu.financial.dao.ResourceDao;
import spsu.edu.financial.model.ExpenseDetails;
import spsu.edu.financial.model.Projects;
import spsu.edu.financial.model.Resources;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class AddExpenseAction extends BaseAction {
	private static final long serialVersionUID = -7493786595379199502L;

	private ExpenseDetails expense;
	private Users finUser;
	private List<Resources> resourceList;
	private List<Projects> projectList;
	private ExpenseDao expenseDao;
	private ResourceDao resourceDao;
	private ProjectDao projectDao;
		
	public String execute(){
		expense = new ExpenseDetails();
		resourceList = resourceDao.getAllResources();
		projectList = projectDao.getAllProjects();
		
		return SUCCESS;
	}
	
	public String save() throws ApplicationException{
		finUser = (Users) getUser();
		if(expense!=null){
			expenseDao.save(expense, finUser.getUserId());
		}
		return "viewExpenses";
	}

	public ExpenseDetails getExpense() {
		return expense;
	}

	public void setExpense(ExpenseDetails expense) {
		this.expense = expense;
	}

	public Users getFinUser() {
		return finUser;
	}

	public void setFinUser(Users finUser) {
		this.finUser = finUser;
	}

	public List<Resources> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resources> resourceList) {
		this.resourceList = resourceList;
	}

	public List<Projects> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Projects> projectList) {
		this.projectList = projectList;
	}

	public ExpenseDao getExpenseDao() {
		return expenseDao;
	}

	public void setExpenseDao(ExpenseDao expenseDao) {
		this.expenseDao = expenseDao;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

}
