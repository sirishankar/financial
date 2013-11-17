<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<div id="nav-menu">
	<s:if test="%{user!=null and user.userId != null}">
		<ul>
			<li><s:a action="viewUsers" namespace="/">Users</s:a></li>
			<li><s:a action="viewResources" namespace="/">Resources</s:a></li>
			<li><s:a action="viewProjects" namespace="/">Projects</s:a></li>
			<li><s:a action="viewExpenses" namespace="/">Expenses</s:a>	</li>
			<li></li><li></li>
			<li><s:a action="logout" namespace="/">Logout</s:a></li>	
		</ul>		
	</s:if>
</div>