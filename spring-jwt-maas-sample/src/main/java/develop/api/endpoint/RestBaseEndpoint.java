package develop.api.endpoint;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import develop.api.endpoint.model.ErrorResponse;
 

@RestController
public class RestBaseEndpoint extends WebMvcConfigurerAdapter {

	protected Logger log = LoggerFactory.getLogger(RestBaseEndpoint.class);
 
	@ExceptionHandler(Exception.class)
	@ResponseBody
	ResponseEntity<ErrorResponse> handleCommonBadRequest(HttpServletRequest req, Exception ex) {
		 
		if (log != null) {
			log.error(ExceptionUtils.getStackTrace(ex));
		}else {
			System.out.println(ExceptionUtils.getStackTrace(ex));
			
		}
		
		final String stackTrace = ExceptionUtils.getStackTrace(ex);

		final String msg = String.format("%s: \n %s", ex.getMessage(), stackTrace);

		ErrorResponse errorResponse = new  ErrorResponse ();

		if (log != null) {
			log.error( (ex==null)?"null":ex.getMessage(),ex);
		}else {
			ex.printStackTrace();
		} 

		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errorResponse);
	}

	 
}
