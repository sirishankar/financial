<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript">
function actionsFormatter(cellvalue,options,row) {
	var editLink = '<a href="editResource_execute?resourceId='+row.resourceId+'">edit</a>';	
	var deleteLink = '<a href="editResource_delete?resourceId='+row.resourceId+'" onclick="return confirmDialog();">delete</a>';
	
	return editLink  + ' | ' + deleteLink;
}
function confirmDialog(){
	var ret = confirm("Do you want to delete the resoure?");
	return ret;
}
</script>
<div>
	<div class="header"> View Resources </div>
	
	<div style="padding: 10px;">
		<div style="font-size:10pt; padding-left:400px;"> 
			<a href="addResource_execute.action">Add a New Resource</a>
		</div>		
	    <s:url var="remoteurl" action="viewResourceJson"/>
		<sjg:grid id="gridtable" dataType="json" href="%{remoteurl}" gridModel="resourceList"
			pager="false" rownumbers="false" rowNum= "-1" viewrecords="true" resizable="false" resizableHandles="false" >
	        
	        <sjg:gridColumn name="resourceId" index="resourceId" title="Id" sortable="false" width="50"/>
	        <sjg:gridColumn name="description" index="description" title="Description" sortable="false" width="250"/>   	        
	        <sjg:gridColumn name="category" index="category" title="Category" sortable="false" width="150"/>
			<sjg:gridColumn name="actions" formatter="actionsFormatter"  title="Actions" sortable="false" width="80"/> 	        
	    </sjg:grid>
    </div>
</div>