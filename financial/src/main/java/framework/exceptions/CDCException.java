package framework.exceptions;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 * <p>A base class for all PHIN exceptions. </p>
 * <p>Want two constructors: one w/ (String msg), and one w/ (String msg, Exception cause)</p>
 *
 * <P>The CDCException class acts as Contract to identify exceptions raised on our code,
 * not on third party Java code.</P>

 * <P>This exception does not support internationalized error messages. An Error key mapped to a
 * resource bundle will added, so clients dealing with these exceptions can look for the error
 * messages on the appropriate locale.</P>
 *
 * <P>Other intents to achieve here are:
 * <UL>
 * <LI>Make the Chaining of exceptions mandatory via code - Not viable, since constructors are not inherited.</LI>
 * <LI>Make the Logging of exceptions mandatory here - Done</LI>
 * <UL>
 * Analysis are still under revision to see the possibility of those two requirements to be implemented here.</P>
 *
 * @author <a href="mailto:mcq1@cdc.gov">Marcelo Caldas</a>
 * @version 1.0
 */
public abstract class CDCException extends Exception {
	Logger logger = Logger.getLogger(CDCException.class.getName());
	private String[] args = new String[5];
//	private static final String ERROR_PROPERTIES_FILES = "errorBundle";

	/** This property exists, so Web Services can serialize the message and foward it to clients. */
	private String message;
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String newValue) {
		this.message = newValue;
	}

	protected CDCException() {
		super();
	}
	public CDCException(String msg) {
		this(msg, null, null, null, null, null, null);
	}
	public CDCException(String msg, String arg0) {
		this(msg, null, arg0, null, null, null, null);
	}
	public CDCException(String msg, String arg0, String arg1) {
		this(msg, null, arg0, arg1, null, null, null);
	}
	public CDCException(String msg, String arg0, String arg1, String arg2) {
		this(msg, null, arg0, arg1, arg2, null, null);
	}
	public CDCException(String msg, String arg0, String arg1, String arg2, String arg3) {
		this(msg, null, arg0, arg1, arg2, arg3, null);
	}
	public CDCException(String msg, String arg0, String arg1, String arg2, String arg3, String arg4) {
		this(msg, null, arg0, arg1, arg2, arg3, arg4);
	}
	public CDCException(String msg, Exception cause) {
		this(msg, cause, null, null, null, null, null);
	}
	public CDCException(String msg, Exception cause, String arg0) {
		this(msg, cause, arg0, null, null, null, null);
	}
	public CDCException(String msg, Exception cause, String arg0, String arg1) {
		this(msg, cause, arg0, arg1, null, null, null);
	}
	public CDCException(String msg, Exception cause, String arg0, String arg1, String arg2) {
		this(msg, cause, arg0, arg1, arg2, null, null);
	}
	public CDCException(String msg, Exception cause, String arg0, String arg1, String arg2, String arg3) {
		this(msg, cause, arg0, arg1, arg2, arg3, null);
	}
	public CDCException(String msg, Exception cause, String arg0, String arg1, String arg2, String arg3, String arg4) {
		super(msg, cause);
		this.message = msg;
		this.args[0] = arg0;
		this.args[1] = arg1;
		this.args[2] = arg2;
		this.args[3] = arg3;
		this.args[4] = arg4;
		//If there's no cause, this is cause:
		if (cause == null) {
			cause = this;
		}
		String loggerBelongsTo = cause.getStackTrace()[0].getClassName();
		Logger logger = Logger.getLogger(loggerBelongsTo);
		logger.log(this.getLogLevel(), this.translateMessage(), cause);
	}

	/**
	 * This method should be implemented by children Exceptions to determine at what level that
	 * exception should be logger.
	 *
	 * @return a String identifyng the log level for the specific Exception. Possible values are
	 * the constants defined on LanierLogger: SEVERE, WARNING, INFO, FINE, FINER, FINEST
	 */
	public abstract Priority getLogLevel();

	public String getArg0() {
		return args[0];
	}
	public void setArg0(String arg0) {
		this.args[0] = arg0;
	}
	public String getArg1() {
		return this.args[1];
	}
	public void setArg1(String arg1) {
		this.args[1] = arg1;
	}
	public String getArg2() {
		return this.args[2];
	}
	public void setArg2(String arg2) {
		this.args[2] = arg2;
	}
	public String getArg3() {
		return args[3];
	}
	public void setArg3(String arg3) {
		this.args[3] = arg3;
	}
	public String getArg4() {
		return args[4];
	}
	public void setArg4(String arg4) {
		this.args[4] = arg4;
	}

	protected String getArg(int index) {
		return this.args[index];
	}

	public String translateMessage() {
		boolean hasArguments = this.args[0] != null;
		if (hasArguments) {
			StringBuffer result = new StringBuffer(this.getMessage());
			//Get ResourceBundle...
			//Translate Message and arguments...
			int index = 0;
			while (hasArguments) {
				String argumentValue = this.getArg(index);
				String placeHolder = "{" + index++ + "}";
				int startIndex = result.indexOf(placeHolder);
				if (startIndex > 0) {//Make sure we have a placeholder
					int endIndex = startIndex + placeHolder.length();
					if (endIndex > startIndex) {
						result.replace(startIndex, endIndex, argumentValue);
					}
				}
				hasArguments = this.args[index] != null;
			}
			this.message = result.toString();
		}
		return this.message;
	}
//	public String getInternationalizedMessage() {
//		StringBuffer result = new StringBuffer();
//        //Get ResourceBundle...
//        ResourceBundle bundle = ResourceBundle.getBundle(ERROR_PROPERTIES_FILES);
//		String errorKey = bundle.getString(this.getErrorKey());
//		result.append(errorKey);
//		//Translate Message and arguments...
//		boolean hasArguments = this.args[0] != null;
//		int index = 0;
//		while (hasArguments) {
//            String argumentValue = bundle.getString(this.getArg(index));
//			String placeHolder = "{" + index++ + "}";
//			int startIndex = result.indexOf(placeHolder);
//			int endIndex = startIndex + placeHolder.length();
//			result.replace(startIndex, endIndex, argumentValue);
//		}
//		logger.finest("generated message: " + result.toString());
//		return result.toString();
//	}
}