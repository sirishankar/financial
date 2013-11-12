package framework.exceptions;

import org.apache.log4j.Priority;

public class BusinessException extends CDCException {
	public BusinessException() {
		super();
	}
	public BusinessException(String msg) {
		this(msg, null, null, null, null, null, null);
	}

	public BusinessException(String msg, String arg0) {
		this(msg, null, arg0, null, null, null, null);
	}

	public BusinessException(String msg, String arg0, String arg1) {
		this(msg, null, arg0, arg1, null, null, null);
	}

	public BusinessException(String msg, String arg0, String arg1, String arg2) {
		this(msg, null, arg0, arg1, arg2, null, null);
	}

	public BusinessException(String msg, String arg0, String arg1, String arg2, String arg3) {
		this(msg, null, arg0, arg1, arg2, arg3, null);
	}

	public BusinessException(String msg, String arg0, String arg1, String arg2, String arg3, String arg4) {
		this(msg, null, arg0, arg1, arg2, arg3, arg4);
	}

	public BusinessException(String msg, Exception cause) {
		this(msg, cause, null, null, null, null, null);
	}

	public BusinessException(String msg, Exception cause, String arg0) {
		this(msg, cause, arg0, null, null, null, null);
	}

	public BusinessException(String msg, Exception cause, String arg0, String arg1) {
		this(msg, cause, arg0, arg1, null, null, null);
	}

	public BusinessException(String msg, Exception cause, String arg0, String arg1, String arg2) {
		this(msg, cause, arg0, arg1, arg2, null, null);
	}

	public BusinessException(String msg, Exception cause, String arg0, String arg1, String arg2, String arg3) {
		this(msg, cause, arg0, arg1, arg2, arg3, null);
	}

	public BusinessException(String msg, Exception cause, String arg0, String arg1, String arg2, String arg3, String arg4) {
		super(msg, cause, arg0, arg1, arg2, arg3, arg4);
	}

	public Priority getLogLevel() {
		return Priority.WARN;
	}
}