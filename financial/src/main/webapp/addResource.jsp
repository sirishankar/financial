<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="addResource_save" theme="simple">
	<div class="bodyStyle">
		<div class="header"> Add a Resource </div>
		<div style="padding: 10px;">
			<div>
				<div class="leftColumn">Category: </div>
				<div style="display:inline-block;"><s:select list="#{'Person':'Person','Software':'Software','Hardware':'Hardware','Material':'Material','Cost':'Cost'}" name="resource.category"></s:select></div>
			</div>		
			<div>
				<div class="leftColumn">Description: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="resource.description"  /></div>
			</div>						
		</div>
		<div align="center" style="padding:20px;">
			<input type="button" value="Cancel" onclick="location.href='/financial/viewResources.action'">
			<s:submit value="Submit"/>
		</div>
	</div>
</s:form>