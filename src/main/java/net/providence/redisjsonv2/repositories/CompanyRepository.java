package net.providence.redisjsonv2.repositories;

import com.redis.om.spring.repository.RedisDocumentRepository;
import net.providence.redisjsonv2.domain.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends RedisDocumentRepository<Company,String> {

    Optional<Company> findOneByName(String name);

}
