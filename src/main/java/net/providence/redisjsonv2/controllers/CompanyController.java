package net.providence.redisjsonv2.controllers;

import net.providence.redisjsonv2.domain.Company;
import net.providence.redisjsonv2.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    CompanyRepository repository;

    @GetMapping("name/{name}")
    Optional<Company> byName(@PathVariable("name") String name){
        return repository.findOneByName(name);
    }
}
