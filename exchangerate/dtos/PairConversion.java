package exchangerate.dtos;

import com.google.gson.annotations.SerializedName;

public class PairConversion extends DatedResponse {
	@SerializedName("base_code")
	private final String baseCode;
	@SerializedName("target_code")
	private final String targetCode;
	@SerializedName("conversion_rate")
	private final double conversionRate;
	@SerializedName("conversion_result")
	private final double conversionResult;

	public PairConversion(
			String result,
			String errorType,
			String documentation,
			String termsOfUse,
			long timeLastUpdateUnix,
			long timeNextUpdateUnix,
			String timeLastUpdateUtc,
			String timeNextUpdateUtc,
			String baseCode,
			String targetCode,
			double conversionRate,
			double conversionResult
			) {
		super(result, errorType, documentation, termsOfUse, timeLastUpdateUnix, timeNextUpdateUnix, timeLastUpdateUtc, timeNextUpdateUtc);
		this.baseCode=baseCode;
		this.targetCode=targetCode;
		this.conversionRate=conversionRate;
		this.conversionResult=conversionResult;
	}
	
	public final String toString() {
	    return """
	            %s
	            base_code: %s
	            target_code: %s
	            conversion_rate: %.6f
	            conversion_result: %.6f
	            """.formatted(
	                super.toString(),
	                this.baseCode,
	                this.targetCode,
	                this.conversionRate,
	                this.conversionResult
	            );
	}
}
