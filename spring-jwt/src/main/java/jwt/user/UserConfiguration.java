package jwt.user;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import org.mongeez.Mongeez;
import org.mongeez.MongeezRunner;
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

//  @Bean
//  public MongeezRunner mongeezRunner() throws UnknownHostException {
//    MongeezRunner mongeez = new MongeezRunner();
//    mongeez.setExecuteEnabled(true);
//    mongeez.setDbName(databaseName);
//    mongeez.setFile(new ClassPathResource("db/mongeez.xml"));
//    mongeez.setMongo(new MongoClient());
//    return mongeez;
//  }

  @Bean
  public MongoTemplate mongoTemplate(Mongo mongo, MongoDbFactory mongoDbFactory,
                                     MongoConverter converter) throws IOException {
      // make sure that Mongeez runs before Spring Data is initialized
      runMongeez(mongo);

      return new MongoTemplate(mongoDbFactory, converter);
  }

  private void runMongeez(Mongo mongo) throws IOException {
      Mongeez mongeez = new Mongeez();
      mongeez.setMongo(mongo);
      mongeez.setDbName(databaseName);
      mongeez.setFile(new ClassPathResource("db/mongeez.xml"));
      mongeez.process();
  }
}
