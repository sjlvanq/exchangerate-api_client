package exchangerate;

import java.net.URI;
import exchangerate.enums.Endpoint;

public class Request {
	private final URI url;
	private final Endpoint endpoint;

	public Request(URI url, Endpoint endpoint) {
		this.url = url;
		this.endpoint = endpoint;
	}

	public URI getUrl() {
		return url;
	}

	public Endpoint getEndpoint() {
		return endpoint;
	}
}
