<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>	
<link rel="stylesheet" type="text/css" href="<s:url value="/web/css/loginStyle.css"/>">

<s:form action="welcomeAction" theme="simple">
	<div id="loginDiv">
		<img alt="Software Control Package" src="<s:url value="/web/images/headerImage.png"/>" />
		<s:actionerror cssClass="loginErrorMessage"/>
		 <form action="" method="post" name="Login">
			 <table style="width:100%">
				 <tr>
				 	<td><label class="label">User Name:</label></td>
				 </tr>
				 <tr>
				 	<td><s:textfield id="userId" name="userId" /></td>
				 </tr>
				 <tr>
				 	<td>
				 	<label class="label">Password:</label>
				 	</td>
				 </tr>
				 <tr>
				 	<td><s:password id="password" name ="password" /></td>
				 </tr>
				<tr>
				 	<td style="text-align:right"><s:submit id="submit"/></td>
				 </tr>
			 </table>
		</form>
	</div>
</s:form>