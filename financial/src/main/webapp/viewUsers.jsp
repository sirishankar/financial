<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript">
function actionsFormatter(cellvalue,options,row) {
	var editLink = '<a href="editUser_execute?userId='+row.userId+'">edit</a>';	
	var deleteLink = '<a href="editUser_delete?userId='+row.userId+'" onclick="return confirmDialog();">delete</a>';
	
	if(row.allowDelete){
		return editLink  + ' | ' + deleteLink;
	}else{
		return editLink;
	}
}
function confirmDialog(){
	var ret = confirm("Do you wish to delete the user?");
	alert(ret);
	return ret;
}
</script>
<div>
	<div class="header"> View Users </div>
	
	<div style="padding: 10px;">
		<div style="font-size:10pt; padding-left:600px;"> 
			<a href="addUser_execute.action">Add a New User</a>
		</div>		
	    <s:url var="remoteurl" action="viewUsersJson"/>
		<sjg:grid id="gridtable" dataType="json" href="%{remoteurl}" gridModel="usersList"
			pager="false" rownumbers="false" rowNum= "-1" viewrecords="true" resizable="false" resizableHandles="false" >
	        
	        <sjg:gridColumn name="userId" index="userId" title="User" sortable="false"/>
	        <sjg:gridColumn name="userName" index="userName" title="Name" sortable="false"/>
	        <sjg:gridColumn name="email" index="email" title="Email" sortable="false"/>
	        <sjg:gridColumn name="role" index="role" title="Role" sortable="false"/>
			<sjg:gridColumn name="actions" formatter="actionsFormatter"  title="Actions" sortable="false" width="80"/> 
			<sjg:gridColumn name="allowDelete" index="allowDelete" title="allowDelete" hidden="true" />       
	    </sjg:grid>
    </div>
</div>