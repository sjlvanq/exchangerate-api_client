package exchangerate.enums;

import exchangerate.Messages;

public enum ErrorCode {
	
	UNSUPPORTED_CODE("unsupported-code", Messages.get("error.unsupported-code")),
	MALFORMED_REQUEST("malformed-request",  Messages.get("error.malformed-request")),
	INVALID_KEY("invalid-key",  Messages.get("error.invalid-key")),
	INACTIVE_ACCOUNT("inactive-account",  Messages.get("error.inactive-account")),
	QUOTA_REACHED("quota-reached",  Messages.get("error.quota-reached"));
	
	private String errorType;
	private String errorDesc;
	
	ErrorCode(String code, String desc) {
		this.errorType = code;
		this.errorDesc = desc;
	}

	public static String getMessage(String code) {
	    for (ErrorCode ec : values()) {
	        if (ec.errorType.equals(code)) {
	            return ec.errorDesc;
	        }
	    }
	    return null;
	}
}
