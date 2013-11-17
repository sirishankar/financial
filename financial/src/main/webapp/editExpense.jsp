<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<s:form action="editExpense_save" theme="simple">
	<div class="bodyStyle">
		<div class="header"> Edit an Expense </div>
		<div style="padding: 10px;">
			<div>
				<div class="leftColumn">Project Name: </div>
				<div style="display:inline-block;padding-bottom: 5px;">
					<s:select list="projectList" name="expense.projectId" listKey="projectId" listValue="projectName" ></s:select>
				</div>
			</div>
			<div>
				<div class="leftColumn">Resource Name: </div>
				<div style="display:inline-block;padding-bottom: 5px;">
					<s:select list="resourceList" name="expense.resourceId" listKey="resourceId" listValue="description" ></s:select>
				</div>
			</div>										
			<div>
				<div class="leftColumn">Week Number: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="expense.weekNumber"  /></div>
			</div>	
			<div>
				<div class="leftColumn">Hours Worked: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="expense.hoursWorked"  /></div>
			</div>	
			<div>
				<div class="leftColumn">Expenses: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="expense.expenses"  /></div>
			</div>	
			<div>
				<div class="leftColumn">Reference Date:</div>
				<div style="display:inline-block;">
					<sj:datepicker id="referenceDate" name="expense.referenceDate"
								displayFormat="mm/dd/yy" maxDate="0" />
				</div>
			</div>
			<div>
				<div class="leftColumn">Reference Document: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="expense.referenceDocumentation"  /></div>
			</div>																																
		</div>
		<div align="center" style="padding:20px;">
			<s:hidden name="expense.expenseId"/>
			<input type="button" value="Cancel" onclick="location.href='/financial/viewExpenses.action'">
			<s:submit value="Submit"/>
		</div>
	</div>
</s:form>