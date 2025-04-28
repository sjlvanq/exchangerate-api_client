package exchangerate.dtos;

import com.google.gson.annotations.SerializedName;

public class SupportedCodes extends Response {
	@SerializedName("supported_codes")
	private final String[][] supportedCodes;

	public SupportedCodes(
			String result,
			String errorType,
			String documentation,
			String termsOfUse,
			String[][] supportedCodes
			) {
		super(result, errorType, documentation, termsOfUse);
		this.supportedCodes = supportedCodes;
	}

	public final String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()+"\n");
		for (String[] code : this.supportedCodes) {
			sb.append("%s\t%s\n".formatted(code[0],code[1]));
		}
		return sb.toString();
	}
}
