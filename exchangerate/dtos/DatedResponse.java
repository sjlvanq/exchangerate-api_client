package exchangerate.dtos;

import com.google.gson.annotations.SerializedName;

public abstract class DatedResponse extends Response{
	@SerializedName("time_last_update_unix")
	long timeLastUpdateUnix;
	@SerializedName("time_next_update_unix")
	long timeNextUpdateUnix;
	@SerializedName("time_last_update_utc")
	String timeLastUpdateUtc;
	@SerializedName("time_next_update_utc")
	String timeNextUpdateUtc;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("time_last_update_utc: "+this.timeLastUpdateUtc);
		sb.append("\ntime_next_update_utc: "+this.timeNextUpdateUtc);
		return sb.toString();
	}
}
