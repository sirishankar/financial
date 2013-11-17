<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript">
function actionsFormatter(cellvalue,options,row) {
	var editLink = '<a href="editProject_execute?projectId='+row.projectId+'">edit</a>';	
	var deleteLink = '<a href="editProject_delete?projectId='+row.projectId+'" onclick="return confirmDialog();">delete</a>';
	
	return editLink  + ' | ' + deleteLink;
}
function confirmDialog(){
	var ret = confirm("Do you want to delete the resoure?");
	return ret;
}
</script>
<div>
	<div class="header"> View Projects </div>
	
	<div style="padding: 10px;">
		<div style="font-size:10pt; padding-left:400px;"> 
			<a href="addProject_execute.action">Add a New Project</a>
		</div>		
	    <s:url var="remoteurl" action="viewProjectJson"/>
		<sjg:grid id="gridtable" dataType="json" href="%{remoteurl}" gridModel="projectList"
			pager="false" rownumbers="false" rowNum= "-1" viewrecords="true" resizable="false" resizableHandles="false" >
	        
	        <sjg:gridColumn name="projectId" index="projectId" title="Id" sortable="false" width="50"/>
	        <sjg:gridColumn name="projectName" index="projectName" title="Project Name" sortable="false" />   	        
	        <sjg:gridColumn name="status" index="status" title="status" sortable="false" width="80"/>	  
	        <sjg:gridColumn name="startDate" index="startDate" title="Start Date" sortable="false" 
	        	formatter="date" formatoptions="{newformat : 'm/d/y', srcformat : 'Y-m-d H:i:s'}"
	        	 width="80"/>
	        <sjg:gridColumn name="endDate" index="endDate" title="End Date" sortable="false" 
	        	formatter="date" formatoptions="{newformat : 'm/d/y', srcformat : 'Y-m-d H:i:s'}"
	        	 width="80"/>	  
	        <sjg:gridColumn name="finUser.userName" index="userName" title="Manager" sortable="false" />	        	              	        	                      	              	        	              
			<sjg:gridColumn name="actions" formatter="actionsFormatter"  title="Actions" sortable="false" width="80"/> 	        
	    </sjg:grid>
    </div>
</div>