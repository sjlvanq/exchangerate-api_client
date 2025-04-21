package exchangerate.dtos;
import com.google.gson.annotations.*;

public abstract class Response {
	private String result;
	@SerializedName("error-type")
	private String errorType;
	private String documentation;
	@SerializedName("terms_of_use")
	private String termsOfUse;

	public String getResult() {
		return result;
	}

	public String getErrorType() {
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
