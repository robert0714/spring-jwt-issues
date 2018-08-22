package develop.api.endpoint.model;

public class ErrorResponse {
	private String  message;
	private Integer status, errCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getErrCode() {
		return errCode;
	}
	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}
	
}
