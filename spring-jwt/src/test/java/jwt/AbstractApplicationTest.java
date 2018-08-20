package jwt;

import com.mongodb.*;
import jwt.user.UserRepository;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractApplicationTest {

  protected HttpHeaders headers;

  @Value("${local.server.port}")
  protected int port;

  @Value("${secret.key}")
  protected String secretKey;

  @Autowired
  protected MongoTemplate mongoTemplate;

  @Autowired
  protected UserRepository userRepository;

  @Autowired
  protected TestRestTemplate restTemplate ;

  @Before
  public void before() throws IOException {
    headers = new PrePopulatedJsonHttpHeaders();
    seed();
  }

  protected String getToken(Optional<String> username, String credentials) {
    return getToken(username, credentials, 200);
  }

  protected String getToken(Optional<String> username, String credentials, int expectedStatus) {
    HttpEntity<String> entity = new HttpEntity<>(headers);
//    RestTemplate template = new TestRestTemplate(username.orElse(null), credentials) ;
    ResponseEntity<String> response = restTemplate.exchange( "/token", HttpMethod.POST, entity, String.class);
    assertEquals(expectedStatus, response.getStatusCode().value());
    return response.getBody();
  }

  private void seed() throws IOException {
    mongoTemplate.dropCollection("users");
    String command = IOUtils.toString(new ClassPathResource("mongo/seed.js").getInputStream());
    mongoTemplate.execute(db -> db.eval(command));
  }

}
