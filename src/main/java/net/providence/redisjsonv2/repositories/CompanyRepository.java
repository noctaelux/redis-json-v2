package net.providence.redisjsonv2.repositories;

import com.redis.om.spring.repository.RedisDocumentRepository;
import net.providence.redisjsonv2.domain.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends RedisDocumentRepository<Company,String> {

}
