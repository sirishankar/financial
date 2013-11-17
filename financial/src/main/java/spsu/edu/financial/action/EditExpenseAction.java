package spsu.edu.financial.action;

import java.math.BigDecimal;
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

public class EditExpenseAction extends BaseAction {
	private static final long serialVersionUID = 5834830649355135491L;

	private ExpenseDao expenseDao;
	private ProjectDao projectDao;
	private ResourceDao resourceDao;
	private ExpenseDetails expense;
	private Integer expenseId;
	private List<Projects> projectList;
	private List<Resources> resourceList;
	
	public String execute(){
		if(expenseId!=null){
			projectList = projectDao.getAllProjects();
			resourceList = resourceDao.getAllResources();
			expense = expenseDao.getExpense(expenseId);
		}else{
			this.addActionError("Invalud Expense Details.");
		}
		return SUCCESS;
	}

	public String save() throws ApplicationException{
		try{
			Users finUser = (Users) getUser();
			ExpenseDetails originalExpense = expenseDao.getExpense(expense.getExpenseId());		
			Projects project = projectDao.getProject(expense.getProjectId());
			
			BigDecimal actualCost = BigDecimal.ZERO;
			BigDecimal actualHours = BigDecimal.ZERO;
			if(project.getActualCost()==null){
				actualCost = expense.getExpenses();		
			}else{
				actualCost = project.getActualCost().subtract(originalExpense.getExpenses()).add(expense.getExpenses());
			}
			if(project.getActualHours()==null){
				actualHours = expense.getHoursWorked();
			}else{
				actualHours = project.getActualHours().subtract(originalExpense.getHoursWorked()).add(expense.getHoursWorked());		
			}			
						
			project.setActualCost(actualCost);
			project.setActualHours(actualHours);
			projectDao.saveOrUpdate(project, finUser.getUserId());
			
			expenseDao.saveOrUpdate(expense, finUser.getUserId());
		}catch(Exception e){
			addActionError("Error: "+e.getMessage());
			return INPUT;
		}
		return "viewExpenses";
	}
	public String delete() throws ApplicationException {
		if(expenseId!=null){
			expense = expenseDao.getExpense(expenseId);
			expenseDao.delete(expense);
		}else{
			this.addActionError("Invalid Expense. ");
		}
		
		return "viewExpenses";
	}

	public ExpenseDao getExpenseDao() {
		return expenseDao;
	}

	public void setExpenseDao(ExpenseDao expenseDao) {
		this.expenseDao = expenseDao;
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public ExpenseDetails getExpense() {
		return expense;
	}

	public void setExpense(ExpenseDetails expense) {
		this.expense = expense;
	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public List<Projects> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Projects> projectList) {
		this.projectList = projectList;
	}

	public List<Resources> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resources> resourceList) {
		this.resourceList = resourceList;
	}

}
