package spsu.edu.financial.action;

import java.util.List;

import spsu.edu.financial.dao.ExpenseDao;
import spsu.edu.financial.model.ExpenseDetails;
import framework.action.BaseAction;
public class ViewExpensesAction extends BaseAction{
	private static final long serialVersionUID = -6284967468315673671L;
	
	private List<ExpenseDetails> expenseList;	
	private ExpenseDao expenseDao;
	public String execute(){
		
		return SUCCESS;
	}
	
	public String getJSON(){
		expenseList = expenseDao.getAllExpenses();
		
		return SUCCESS;
	}

	public List<ExpenseDetails> getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List<ExpenseDetails> expenseList) {
		this.expenseList = expenseList;
	}

	public ExpenseDao getExpenseDao() {
		return expenseDao;
	}

	public void setExpenseDao(ExpenseDao expenseDao) {
		this.expenseDao = expenseDao;
	}

}
