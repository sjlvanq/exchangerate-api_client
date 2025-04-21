package exchangerate.dtos;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.annotations.SerializedName;

public class Standard extends DatedResponse {
	@SerializedName("base_code")
	String baseCode;
	@SerializedName("conversion_rates")
	Map<String, Double> conversionRates;
	{conversionRates = new TreeMap<String, Double>();}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nconversion_rates:\n");
		for(Map.Entry<String,Double> entry : this.conversionRates.entrySet()) {
			sb.append("\t%s: %s\n".formatted(entry.getKey(), entry.getValue()));
		}
		return sb.toString();
	}
	
}
