package net.providence.redisjsonv2;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import net.providence.redisjsonv2.domain.Company;
import net.providence.redisjsonv2.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.Point;

import java.util.Set;

@SpringBootApplication
@Configuration
@EnableRedisDocumentRepositories
public class RedisJsonV2Application {

    @Autowired
    CompanyRepository companyRepository;

    @Bean
    CommandLineRunner loadTestData() {
        return args -> {
            companyRepository.deleteAll();
            Company redis = Company.of("Redis", "https://redis.com", new Point(-122.066540, 37.377690), 526, 2011);
            redis.setTags(Set.of("fast", "scalable", "reliable"));

            Company microsoft = Company.of("Microsoft", "https://microsoft.com", new Point(-122.124500, 47.640160), 182268, 1975);
            microsoft.setTags(Set.of("innovative", "reliable"));

            companyRepository.save(redis);
            companyRepository.save(microsoft);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisJsonV2Application.class, args);
    }

}
