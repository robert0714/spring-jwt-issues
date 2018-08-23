package develop.api.endpoint.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraInfo {
	private Date txnTime;

	public Date getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(Date txnTime) {
		this.txnTime = txnTime;
	}

}
