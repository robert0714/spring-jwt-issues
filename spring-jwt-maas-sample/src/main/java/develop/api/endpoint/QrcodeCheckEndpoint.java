package develop.api.endpoint;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import develop.api.endpoint.model.ErrorResponse;
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
	 * 
	 */
	@RequestMapping(value = "/query-info", method = RequestMethod.POST) 
	public ResponseEntity<ErrorResponse>  queryInfo(@RequestBody QrcodeQueryInfoRequest request) {
		ResponseEntity<ErrorResponse> check = checkToken(request.getToken());
		if(check !=null ) {
			return check;
		}
		QrcodeQueryInfoResponse result = new QrcodeQueryInfoResponse();
		result.setQrcodeType("paperTicket");		
		result.setId(1234);
		result.setName("童玩節門票");
		result.setCount(1);
		result.setType("個人劵");
		result.setTotal(50);
		result.setPrice(40);
		result.setPoint(10);
		
		return new ResponseEntity<ErrorResponse>(result, HttpStatus.OK);
	}

	/**
	 * 6.核銷UMAJI QR Code API
	 * 
	 */
	@RequestMapping(value = "/check-token", method = RequestMethod.POST)
	public ResponseEntity<ErrorResponse> checkToken(@RequestBody QrcodeCheckTokenRequest request) {		 
		ResponseEntity<ErrorResponse> check = checkToken(request.getToken());
		if(check !=null ) {
			return check;
		}

		QrcodeCheckTokenResponse result = new QrcodeCheckTokenResponse();
		result.setQrcodeType("paperTicket");
		result.setId(7563);
		result.setName("童玩節門票");
		result.setCount(1);
		result.setType("個人劵");
		result.setTotal(50);
		result.setPrice(40);
		result.setPoint(10);
		result.setTimestamp(new Date());
		return new ResponseEntity<ErrorResponse>(result, HttpStatus.OK);
	}

	protected  ResponseEntity<ErrorResponse> checkToken (final String token){
		if (StringUtils.isAllEmpty(token) ||   (token.length() < 14 )) {
			ErrorResponse response = new ErrorResponse();
			response.setErrCode(34005);
			response.setMessage("不是定義的QR Code格式");
			response.setStatus(417);
			return new ResponseEntity<ErrorResponse>(response, HttpStatus.EXPECTATION_FAILED);
		}else if (StringUtils.isNotEmpty(token) && (token.length() > 14 )){
			
			return null ;
		}else {
			return null ;
		}
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
