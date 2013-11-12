package spsu.edu.financial.action;

import org.apache.commons.lang.StringUtils;

import spsu.edu.financial.model.Users;
import framework.action.BaseAction;

public class LoginAction extends BaseAction{
	private static final long serialVersionUID = -3974701998106214075L;

	public String execute(){
		Users user = (Users) getUser();
		
		if(user!=null && StringUtils.isNotBlank(user.getUserId())){
			setErrorText("");
			return SUCCESS;
		}else{
			this.addActionError(errorText);
			return INPUT;
		}
		
	}
}
