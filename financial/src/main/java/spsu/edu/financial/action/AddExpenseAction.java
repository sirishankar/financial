package spsu.edu.financial.action;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.Preparable;

import spsu.edu.financial.dao.ExpenseDao;
import spsu.edu.financial.dao.ProjectDao;
import spsu.edu.financial.dao.ResourceDao;
import spsu.edu.financial.model.ExpenseDetails;
import spsu.edu.financial.model.Projects;
import spsu.edu.financial.model.Resources;
import spsu.edu.financial.model.Users;
import framework.action.BaseAction;
import framework.exceptions.ApplicationException;

public class AddExpenseAction extends BaseAction implements Preparable {
	private static final long serialVersionUID = -7493786595379199502L;

	private ExpenseDetails expense;
	private Users finUser;
	private List<Resources> resourceList;
	private List<Projects> projectList;
	private ExpenseDao expenseDao;
	private ResourceDao resourceDao;
	private ProjectDao projectDao;
	
	private String weekNumber;
	private String hoursWorked;
	private String expenses;
		
	public void prepare(){
		resourceList = resourceDao.getAllResources();
		setProjectList(projectDao.getAllProjects());		
	}
	public String execute(){
		expense = new ExpenseDetails();

		
		return SUCCESS;
	}
	
	public String save() throws ApplicationException{
		try{
		finUser = (Users) getUser();
		if(expense!=null){			
			expense.setWeekNumber(Integer.parseInt(weekNumber));
			expense.setHoursWorked(new BigDecimal(hoursWorked));
			expense.setExpenses(new BigDecimal(expenses));
			BigDecimal actualCost = BigDecimal.ZERO;
			BigDecimal actualHours = BigDecimal.ZERO;
			Projects project = projectDao.getProject(expense.getProjectId());
			if(project.getActualCost()==null){
				actualCost = expense.getExpenses();		
			}else{
				actualCost = project.getActualCost().add(expense.getExpenses());
			}
			if(project.getActualHours()==null){
				actualHours = expense.getHoursWorked();
			}else{
				actualHours = project.getActualHours().add(expense.getHoursWorked());
			}
			
			project.setActualCost(actualCost);
			project.setActualHours(actualHours);
			projectDao.saveOrUpdate(project, finUser.getUserId());
			expenseDao.save(expense, finUser.getUserId());
		}
		}catch(Exception ex){
			addActionError("Error: "+ex.getMessage());
			return INPUT;
		}
		return "viewExpenses";
	}
	public void validate(){
		if(expense!=null){
			if(StringUtils.isNotBlank(getWeekNumber())){
				try{
				Integer num = Integer.parseInt(getWeekNumber());
				if(num <=0 || num > 52){
					this.addActionError("Week Number: invalid Week Number.");
				}
				}catch(Exception e){
					this.addActionError("Week Number: please enter value between 1 and 52.");
				}
			}else{
				this.addActionError("Week Number: invalid Week Number.");
			}
			if(StringUtils.isNotBlank(getHoursWorked())){
				try{
				BigDecimal hours = new BigDecimal(getHoursWorked());
	
				}catch(Exception e){
					this.addActionError("Hours Worked: please enter valid decimal number.");
				}
			}else{
				this.addActionError("Hours Worked: invalid hours worked.");
			}
			if(StringUtils.isNotBlank(getExpenses())){
				try{
				BigDecimal exp = new BigDecimal(getExpenses());
	
				}catch(Exception e){
					this.addActionError("Expenses: please enter valid decimal number.");
				}
			}else{
				this.addActionError("Expenses: invalid expenses.");
			}
		}
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

	public List<Projects> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Projects> projectList) {
		this.projectList = projectList;
	}
	public String getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}
	public String getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(String hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public String getExpenses() {
		return expenses;
	}
	public void setExpenses(String expenses) {
		this.expenses = expenses;
	}

}
