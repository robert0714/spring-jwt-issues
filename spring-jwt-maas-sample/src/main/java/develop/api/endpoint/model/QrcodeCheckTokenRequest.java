package develop.api.endpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QrcodeCheckTokenRequest {
	private String token, serialNumber, deviceID, scanDeviceID, extraInfo, cardId;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getScanDeviceID() {
		return scanDeviceID;
	}

	public void setScanDeviceID(String scanDeviceID) {
		this.scanDeviceID = scanDeviceID;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
}
