package exchangerate.dtos;

import com.google.gson.annotations.SerializedName;

public abstract class DatedResponse extends Response{
	@SerializedName("time_last_update_unix")
	private final long timeLastUpdateUnix;
	@SerializedName("time_next_update_unix")
	private final long timeNextUpdateUnix;
	@SerializedName("time_last_update_utc")
	private final String timeLastUpdateUtc;
	@SerializedName("time_next_update_utc")
	private final String timeNextUpdateUtc;

	public DatedResponse(
			String result,
			String errorType,
			String documentation,
			String termsOfUse,
			long timeLastUpdateUnix,
			long timeNextUpdateUnix,
			String timeLastUpdateUtc,
			String timeNextUpdateUtc
	) {
		super(result, errorType, documentation, termsOfUse);
		this.timeLastUpdateUnix = timeLastUpdateUnix;
		this.timeNextUpdateUnix = timeNextUpdateUnix;
		this.timeLastUpdateUtc = timeLastUpdateUtc;
		this.timeNextUpdateUtc = timeNextUpdateUtc;
	}
	
	public String toString() {
		return """
				%s
				time_last_update_utc: %s
				time_next_update_utc: %s
				""".formatted(super.toString(),
						this.timeLastUpdateUtc,
						this.timeNextUpdateUtc);
	}
}
