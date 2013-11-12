package framework.filters;


import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * <P>
 * This filter intercepts all requests for Phindir Admin Application and verify
 * that the user has been authorized to access the application.
 * </P>
 * It works together with SiteMinderFilter which will presents the user
 * principle to the web service. If the user is authorized, it will be stored in
 * the session attribute. If a user has no autorization for the access, the
 * request will be redirected to the error page.
 * <P>
 * Deployment: <BR>
 * Simply map this Filter to all URL-patterns that will need access to admin app
 * </P>
 * <p/>
 * 
 * @author czv8 </a>
 */
public class RequestSanitizerFilter implements Filter {

    private static final String EXCEPTION_MESSAGE_FOR_UNSANITARY_INPUT = "Invalid request input";

	private static String INPUT_ERROR_PAGE_URI;
	private static String INVALID_QUERY_STRING_INPUT;
	private static final String INPUT_ERROR_PAGE_URI_KEY = "Input_Error_Page_URI";
	private static final String INVALID_QUERY_STRING_INPUT_KEY = "Invalid_Query_String_Input";
	
	private static final String SEESION_COOKIE_NAME = "jsessionid";

	public void init(FilterConfig filterConfig) throws ServletException {
		INPUT_ERROR_PAGE_URI = filterConfig.getInitParameter(INPUT_ERROR_PAGE_URI_KEY);
		INVALID_QUERY_STRING_INPUT = filterConfig.getInitParameter( INVALID_QUERY_STRING_INPUT_KEY );
		if ( StringUtils.isEmpty( INVALID_QUERY_STRING_INPUT ) ) {
			INVALID_QUERY_STRING_INPUT = "[^<>&;='\":]{1,}";
		}
	}
		
	public void doFilter(ServletRequest sRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) sRequest;
		try {
	        sanitize( request );
			//TODO: remove this after the problem resolved
			//deMystify( request );
		} catch ( Exception e ) {
			//forward to error page
			request.setAttribute("org.apache.struts.action.EXCEPTION", e);
			//redirect
			request.getRequestDispatcher(INPUT_ERROR_PAGE_URI).forward( request, response);
			return; 
	    }
	    chain.doFilter( request, response );	
	}

	public void destroy() {
	}
    
    /**
     * <p>To check for the sanitity of the query string</p>
     * @param request
     * @throws Exception
     */
    public void sanitize( HttpServletRequest request ) throws Exception {
        String queryString = request.getQueryString();
        if ( StringUtils.isNotEmpty( queryString ) ) {
	        Enumeration paramNames = request.getParameterNames();
	        if ( paramNames != null ) {
	            while ( paramNames.hasMoreElements() ) {
	                String strParam = (String) paramNames.nextElement();
	                if ( strParam.equalsIgnoreCase(SEESION_COOKIE_NAME ) ){
	                    continue;
	                }
	                if ( queryString.indexOf( strParam ) >= 0 ) {
	                    String strValue = request.getParameter( strParam );
	                    if ( StringUtils.isNotEmpty( strValue ) ) {
			                if ( unsanitary( strValue )) {
			                    throw new Exception ( EXCEPTION_MESSAGE_FOR_UNSANITARY_INPUT );
			                }
		                } else {
		                    //check if values are arrays
		                    String[] arrValue = request.getParameterValues( strParam );
		                    if ( arrValue != null ) {
								for (String anArrValue : arrValue) {
									if (StringUtils.isNotEmpty(anArrValue)) {
										if (unsanitary(anArrValue)) {
											throw new Exception(EXCEPTION_MESSAGE_FOR_UNSANITARY_INPUT);
										}
									}
								}
		                    }
		                }
	                }
	            }
	        }
        }
    }

    /**
     * <p>To check if an input value from HttpServletRequest will causes any security vulnerabilty</p>
     * A string which contains the following special characters are considered unsanitary:
     * <>&;='"
     * @param pStrValue
     * @return boolean
     */
    private boolean unsanitary(String pStrValue) {
        //this can be made configurable in web.xml using the key: INVALID_QUERY_STRING_INPUT
        //String strExp = "[^<>&;='\":]{1,}";
        Pattern p = Pattern.compile( INVALID_QUERY_STRING_INPUT );
        return !p.matcher( pStrValue ).matches();
    }

}