package exchangerate.dtos;

import com.google.gson.annotations.SerializedName;

public class PairConversion extends DatedResponse {
	@SerializedName("base_code")
	String baseCode;
	@SerializedName("target_code")
	String targetCode;
	@SerializedName("conversion_rate")
	double conversionRate;
	@SerializedName("conversion_result")
	double conversionResult;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("base_code: "+this.baseCode);
		sb.append("\ntarget_code: "+this.targetCode);
		sb.append("\nconversion_rate: "+String.valueOf(this.conversionRate));
		if(this.conversionResult > 0) {
			sb.append("\nconversion_result: "+String.valueOf(this.conversionResult));
		}
		return sb.toString();
	}
}
