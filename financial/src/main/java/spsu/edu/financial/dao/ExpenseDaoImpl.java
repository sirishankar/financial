package spsu.edu.financial.dao;

import java.util.List;

import spsu.edu.financial.model.ExpenseDetails;
import framework.dao.BaseDAO;

public class ExpenseDaoImpl extends BaseDAO implements ExpenseDao {

	@Override
	public ExpenseDetails getExpense(Integer expenseId) {
		ExpenseDetails expense = (ExpenseDetails) this.getHibernateTemplate().get(ExpenseDetails.class, expenseId);
		
		return expense;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpenseDetails> getAllExpenses() {
		List<ExpenseDetails> allExpenses = this.getHibernateTemplate().findByNamedQuery("getAllExpenses");

		return allExpenses;
	}

}
