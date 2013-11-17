<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url forceAddSchemeHostAndPort="true" includeParams="all" var="originalRequest" encode="false" escapeAmp="false"/>

<div id="pageHeader">
	<div id="headerContent">
		<div style="float: left; font-size:1.4em;padding-left: 10px;">
			<img alt="Software Control Package" height="80px" src="<s:url value="/web/images/headerImage.png"/>" />
		</div>
		
		<div style="float: right; margin-right:50px; width:250px;">		
			<div style="width: 300px; margin: 10px; position: relative; top: 50%; margin-left: 5px;">
				Hello, <s:property value="%{user.firstName}"/> <s:property value="%{user.lastName}"/>
			</div>
		</div>
	</div>
	
	<div id="headerDivider"> </div>
</div>

