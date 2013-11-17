<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript">
function actionsFormatter(cellvalue,options,row) {
	var editLink = '<a href="editExpense_execute?expenseId='+row.expenseId+'">edit</a>';	
	var deleteLink = '<a href="editExpense_delete?expenseId='+row.expenseId+'" onclick="return confirmDialog();">delete</a>';
	
	return editLink  + ' | ' + deleteLink;
}
function confirmDialog(){
	var ret = confirm("Do you want to delete the resoure?");
	return ret;
}
</script>
<div>
	<div class="header"> View Expenses </div>
	
	<div style="padding: 10px;">	
		<div style="font-size:10pt; padding-left:545px; margin:5px;"> 
			<a href="addExpense_execute.action"><img alt="Add New Expense" class="iconImage" src="<s:url value="/web/images/add.png"/>" /> Add New Expense</a>
		</div>		
	    <s:url var="remoteurl" action="viewExpensesJson"/>
		<sjg:grid id="gridtable" dataType="json" href="%{remoteurl}" gridModel="expenseList"
			pager="false" rownumbers="false" rowNum= "-1" viewrecords="true" resizable="false" resizableHandles="false" >
	        
	        <sjg:gridColumn name="expenseId" index="expenseId" title="Id" sortable="false" width="50"/>
	        <sjg:gridColumn name="project.projectName" index="projectName" title="Project Name" sortable="false" />
	        <sjg:gridColumn name="resource.description" index="description" title="Resource Description" sortable="false" />
	        <sjg:gridColumn name="weekNumber" index="weekNumber" title="Week" sortable="false" width="80"/>	  	         	           	        
	        <sjg:gridColumn name="hoursWorked" index="hoursWorked" title="Hours Worked" sortable="false" width="80"/>	  
	        <sjg:gridColumn name="expenses" index="expenses" title="Expenses" sortable="false" width="80"/>	  
			<sjg:gridColumn name="actions" formatter="actionsFormatter"  title="Actions" sortable="false" width="80"/> 	        
	    </sjg:grid>
    </div>
</div>