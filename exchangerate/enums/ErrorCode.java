package exchangerate.enums;

public enum ErrorCode {
	
	UNSUPPORTED_CODE("unsupported-code", "El código de moneda que ha proporcionado no es un código ISO 4217 válido o no está disponible. Ejecute el programa con la opción --list para obtener un listado de códigos válidos."),
	MALFORMED_REQUEST("malformed-request", "La solicitud enviada no ha podido procesarse."),
	INVALID_KEY("invalid-key", "No es posible validar la clave de API proporcionada."),
	INACTIVE_ACCOUNT("inactive-account", "La dirección de correo electrónico con la que ha registrado su cuenta en ExchangeRate-API no ha sido confirmada."),
	QUOTA_REACHED("quota-reached", "Su cuenta ha alcanzado el límite de solicitudes disponibles para su plan actual.");
	
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
