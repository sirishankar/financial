<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:form action="editProject_save" theme="simple">
	<div class="bodyStyle">
		<div class="header"> Edit Project </div>
		<div style="padding: 10px;">

			<div>
				<div class="leftColumn">Project Name: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="project.projectName"  /></div>
			</div>						
			<div>
				<div class="leftColumn">Description: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="project.description"  /></div>
			</div>	
			<div>
				<div class="leftColumn">Status: </div>
				<div style="display:inline-block;"><s:select list="#{'In Progress':'In Progress','Pending':'Pending','Completed':'Completed'}" name="project.status"></s:select></div>
			</div>	
			<div>
				<div class="leftColumn">Start Date: </div>
				<div style="display:inline-block;">
					<sj:datepicker id="startDate" name="project.startDate"
								displayFormat="mm/dd/yy" maxDate="0" />
				</div>
			</div>	
			<div>
				<div class="leftColumn">End Date: </div>
				<div style="display:inline-block;">
					<sj:datepicker id="endDate" name="project.endDate"
								displayFormat="mm/dd/yy" maxDate="0" />
				</div>
			</div>	
			<div>
				<div class="leftColumn">Projected Cost: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="project.projectedCost"  /></div>
			</div>	
			<div>
				<div class="leftColumn">Client Name: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="project.clientName"  /></div>
			</div>	
			<div>
				<div class="leftColumn">Client Email: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:textfield name="project.clientEmail"  /></div>
			</div>	
			<div>
				<div class="leftColumn">Manager: </div>
				<div style="display:inline-block;padding-bottom: 5px;">
					<s:select list="userList" name="project.managerId" listKey="userId" listValue="userName" ></s:select>
				</div>
			</div>
			<div>
				<div class="leftColumn">Actual Cost: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:property value="project.actualCost"/></div>
			</div>	
			<div>
				<div class="leftColumn">Actual Hours: </div>
				<div style="display:inline-block;padding-bottom: 5px;"><s:property value="project.actualHours"  /></div>
			</div>																																				
		</div>
		<div align="center" style="padding:20px;">
			<s:hidden name="project.projectId" />
			<input type="button" value="Cancel" onclick="location.href='/financial/viewProjects.action'">
			<s:submit value="Submit"/>
		</div>
	</div>
</s:form>