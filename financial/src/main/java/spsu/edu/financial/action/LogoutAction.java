package spsu.edu.financial.action;

import framework.action.BaseAction;

public class LogoutAction extends BaseAction{
	private static final long serialVersionUID = 2976345759626410984L;

	public String execute(){
		if(session!=null){
			session.clear();
		}
				
		return SUCCESS;
	}
}
