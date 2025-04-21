package exchangerate;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.*;
import exchangerate.dtos.*;
import exchangerate.enums.ErrorCode;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {		
		Config.init();

		CLI cli = new CLI();
		Request req = cli.parse(args);

		if(req==null) {
			cli.showHelp();
			return;
		}

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(req.getUrl())
				.build();

		String json;
		try {			
			HttpResponse<String> response = client
					.send(request, HttpResponse.BodyHandlers.ofString());
			
			json = response.body();
		
		} catch (IOException | InterruptedException e) {
			System.err.println("Error: " + e.getMessage());
			return;
		}

		Gson gson = new Gson();

		Response jresponse = null;
		switch(req.getEndpoint()) {
		case PAIR: case PAIR_WITH_AMMOUNT:
			jresponse = gson.fromJson(json, PairConversion.class);
			break;
		case STANDARD:
			jresponse = gson.fromJson(json, Standard.class);
			break;
		case SUPPORTED_CODES:
			jresponse = gson.fromJson(json, SupportedCodes.class);
			break;
		}

		if (jresponse.getResult().equals("error")) {
			System.out.println(
					ErrorCode.getMessage(jresponse.getErrorType()));
			return;
		}

		System.out.println(jresponse);
	}
}
