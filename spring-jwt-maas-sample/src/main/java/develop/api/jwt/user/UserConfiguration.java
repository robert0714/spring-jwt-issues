package develop.api.jwt.user;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import java.io.IOException;
import java.net.UnknownHostException;

@Configuration
public class UserConfiguration {

  @Value("${spring.data.mongodb.database}")
  private String databaseName;


}
