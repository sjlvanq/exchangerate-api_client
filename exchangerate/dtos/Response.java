package exchangerate.dtos;
import com.google.gson.annotations.*;

public abstract class Response {
	private final String result;
	@SerializedName("error-type")
	private final String errorType;
	private final String documentation;
	@SerializedName("terms_of_use")
	private final String termsOfUse;

	public Response(String result, String errorType, String documentation, String termsOfUse) {
		super();
		this.result = result;
		this.errorType = errorType;
		this.documentation = documentation;
		this.termsOfUse = termsOfUse;
	}

	public final String getResult() {
		return result;
	}

	public final String getErrorType() {
		return errorType;
	}

	public String toString() {
		return """
				result: %s,
				documentation: %s,
				terms_of_use: %s
				""".formatted(
						this.result, 
						this.documentation, 
						this.termsOfUse);
	}
}
