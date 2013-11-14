<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:form action="welcomeAction" theme="simple">
	<div class="bodyStyle">
		<div style="padding-top:100px;padding-bottom:20px;">
			<div>
				<div class="leftColumn">Enter User Id: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield id="userId" name="userId" /></div>
			</div>
			<div>
				<div class="leftColumn">Enter Password: </div>
				<div style="display:inline-block;"><s:password id="password" name ="password" /></div>
			</div>
		</div>
		<div align="center">
			<s:submit id="submit"/>
		</div>
	</div>
</s:form>