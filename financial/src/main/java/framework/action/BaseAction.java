package framework.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import spsu.edu.financial.model.Users;

import com.opensymphony.xwork2.ActionSupport;

import framework.security.User;

public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware{
	private static final long serialVersionUID = 2475322179448428856L;
	
	public static String USER_SESSION_ATTRIBUTE = "USER_SESSION_ATTRIBUTE";
	public Logger logger = Logger.getLogger(BaseAction.class);

	protected Map session;

	public HttpServletRequest request;
	public HttpServletResponse response;

	protected String SUCCESS = "success";
	protected String errorText = "";

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public User getUser() {
		return (User) session.get(USER_SESSION_ATTRIBUTE);
	}

	public void setUser(User user) {
		session.put(USER_SESSION_ATTRIBUTE, user);
	}
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

}
