package develop.api.endpoint;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import develop.api.endpoint.model.QrcodeCheckTokenRequest;
import develop.api.endpoint.model.QrcodeCheckTokenResponse;
import develop.api.endpoint.model.QrcodeQueryInfoRequest;
import develop.api.endpoint.model.QrcodeQueryInfoResponse;
import develop.api.endpoint.model.QrcodeQueryOrderRequest;
import develop.api.endpoint.model.QrcodeQueryOrderResponse;

@RestController
@RequestMapping(value = "/qrcode")
public class QrcodeCheckEndpoint {

	/**
	 * 5.查詢可核銷QR Code 資訊 API

	 */
	@RequestMapping(value = "/query-info", method = RequestMethod.POST)
	public QrcodeQueryInfoResponse queryInfo(@RequestBody QrcodeQueryInfoRequest request) {
		QrcodeQueryInfoResponse result = new QrcodeQueryInfoResponse();
		return result;
	}
	
	/**
	 * 6.核銷UMAJI QR Code API

	 */
	@RequestMapping(value = "/check-token", method = RequestMethod.POST)
	public QrcodeCheckTokenResponse checkToken(@RequestBody QrcodeCheckTokenRequest request) {
		QrcodeCheckTokenResponse result = new QrcodeCheckTokenResponse();
		return result;
	}
	
	
	
	
	/**
	 * 7.查詢訂單API
	 */
	@RequestMapping(value = "/query-order", method = RequestMethod.POST)
	public QrcodeQueryOrderResponse queryOrder(@RequestBody QrcodeQueryOrderRequest request) {
		QrcodeQueryOrderResponse result = new QrcodeQueryOrderResponse();
		return result;
	}

}
