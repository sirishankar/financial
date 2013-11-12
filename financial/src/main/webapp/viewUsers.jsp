<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<div>
	<div style="padding-top:20px;"></div>
    <s:url var="remoteurl" action="viewUsersJson"/>
    <sjg:grid id="gridtable" caption="View Users"  dataType="json"
        href="%{remoteurl}" pager="false" gridModel="usersList" rownumbers="false">
        
        <sjg:gridColumn name="userId" index="userId" title="User" sortable="false"/>
        <sjg:gridColumn name="userName" index="userName" title="Name" sortable="false"/>
        <sjg:gridColumn name="email" index="email" title="Email" sortable="false"/>
        <sjg:gridColumn name="role" index="role" title="Role" sortable="false"/>
    </sjg:grid>
</div>