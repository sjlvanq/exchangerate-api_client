package exchangerate.dtos;

import java.util.Map;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

public class Standard extends DatedResponse {
	@SerializedName("base_code")
	private final String baseCode;
	@SerializedName("conversion_rates")
	private final Map<String, Double> conversionRates;
	public Standard(
			String result,
			String errorType,
			String documentation,
			String termsOfUse,
			long timeLastUpdateUnix,
			long timeNextUpdateUnix,
			String timeLastUpdateUtc,
			String timeNextUpdateUtc,
			Map<String, Double> conversionRates,
			String baseCode) {
		super(
				result,
				errorType,
				documentation,
				termsOfUse,
				timeLastUpdateUnix,
				timeNextUpdateUnix,
				timeLastUpdateUtc,
				timeNextUpdateUtc
			);
		this.conversionRates = new HashMap<>(conversionRates);

		this.baseCode = baseCode;
	}
	
	public final String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nconversion_rates:\n");
		for(Map.Entry<String,Double> entry : this.conversionRates.entrySet()) {
			sb.append("\t%s: %s\n".formatted(entry.getKey(), entry.getValue()));
		}
		return sb.toString();
	}
	
}
