<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url forceAddSchemeHostAndPort="true" includeParams="all" var="originalRequest" encode="false" escapeAmp="false"/>

<div id="pageHeader">
	<div id="headerContent">
		<div style="float: left; font-size:1.4em;padding-left: 10px;">Software Control Package</div>
		<div style="float: right;padding-right: 10px;">Hello, <s:property value="%{user.firstName}"/> <s:property value="%{user.lastName}"/></div>
	</div>
	
	<div id="headerDivider"> </div>
</div>

