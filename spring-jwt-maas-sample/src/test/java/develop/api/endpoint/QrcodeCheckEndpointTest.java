package develop.api.endpoint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import develop.api.endpoint.model.QrcodeCheckTokenRequest;
import develop.api.endpoint.model.QrcodeQueryInfoRequest;
import develop.api.endpoint.model.QrcodeQueryInfoResponse;
import develop.api.endpoint.model.QrcodeQueryOrderRequest; 


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = develop.api.Application.class)
@DirtiesContext
public class QrcodeCheckEndpointTest {
	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(QrcodeCheckEndpointTest.class);

	/** The rest template. */
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void testQueryInfo() throws Exception {
		String uri = "/qrcode/query-info";
		QrcodeQueryInfoRequest requestData = new QrcodeQueryInfoRequest();  

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//		headers.set("X-Authorization", "Bearer " + token);
		headers.set("X-Requested-With", "XMLHttpRequest");

		HttpEntity<?> request = new HttpEntity<Object>(requestData, headers);

		String response = restTemplate.postForObject(uri, request, String.class);
		System.out.println(response);;
	}

	@Test
	public void testCheckToken() throws Exception {
		String uri = "/qrcode/check-token";
		QrcodeCheckTokenRequest requestData = new QrcodeCheckTokenRequest(); 
 

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//		headers.set("X-Authorization", "Bearer " + token);
		headers.set("X-Requested-With", "XMLHttpRequest");

		HttpEntity<?> request = new HttpEntity<Object>(requestData, headers);

		String response = restTemplate.postForObject(uri, request, String.class);
		System.out.println(response);;
	}

	@Test
	public void testQueryOrder() throws Exception {
		String uri = "/qrcode/query-order";
		QrcodeQueryOrderRequest requestData = new QrcodeQueryOrderRequest(); 
 

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//		headers.set("X-Authorization", "Bearer " + token);
		headers.set("X-Requested-With", "XMLHttpRequest");

		HttpEntity<?> request = new HttpEntity<Object>(requestData, headers);

		String response = restTemplate.postForObject(uri, request, String.class);
		System.out.println(response);;
	}

}
