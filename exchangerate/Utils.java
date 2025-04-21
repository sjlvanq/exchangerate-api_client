package exchangerate;

import java.net.URI;
import java.net.URISyntaxException;

public class Utils {
	private static URI getBaseURI() throws URISyntaxException {
		return new URI(getProtocol(), 
				Config.prop("api.host"),
				Config.prop("api.version") + "/" + Config.prop("api.key") + "/", 
				null, null);
	}
	
	// GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/codes
	public static URI buildUrl() throws URISyntaxException {
		return Utils.getBaseURI().resolve("codes/");
	}
	
	// GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD
	public static URI buildUrl(String currency) throws URISyntaxException {
		return Utils.getBaseURI().resolve("latest/"+currency);
	}
	
	// GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP
	public static URI buildUrl(String baseCurrency, String targetCurrency) throws URISyntaxException {
		return Utils.getBaseURI().resolve("pair/"+ baseCurrency + "/" + targetCurrency);
	}
	
	// GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT
	public static URI buildUrl(String baseCurrency, String targetCurrency, double amount) throws URISyntaxException {
		return Utils.getBaseURI().resolve("pair/" + baseCurrency + "/" + targetCurrency + "/" + String.valueOf(amount));
	}
	
	private static String getProtocol() {
		return Boolean.valueOf(Config.prop("api.ssl")) ? "https" : "http";
	}
}
