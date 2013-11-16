<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="addUser_save" theme="simple">
	<div class="bodyStyle">
		<div class="header"> Add User </div>
		<div style="padding: 10px;">
			<div>
				<div class="leftColumn">User Id: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="finUser.userId"  /></div>
			</div>
			<div>
				<div class="leftColumn">First Name: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="finUser.firstName" /></div>
			</div>
			<div>
				<div class="leftColumn">Last Name: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="finUser.lastName"/></div>
			</div>
			<div>
				<div class="leftColumn">Email: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="finUser.email"/></div>
			</div>									
			<div>
				<div class="leftColumn">Password: </div>
				<div style="display:inline-block;"><s:password name ="finUser.password" /></div>
			</div>	
			<div>
				<div class="leftColumn">Role: </div>
				<div style="display:inline-block;"><s:select list="#{'Administrator':'Administrator','Project Manager':'Project Manager'}" name="finUser.role"></s:select></div>
			</div>					
		</div>
		<div align="center" style="padding:20px;">
			<s:hidden name="finUser.allowDelete" value="true"></s:hidden>
			<input type="button" value="Cancel" onclick="location.href='/financial/viewUsers.action'">
			<s:submit value="Submit"/>
		</div>
	</div>
</s:form>