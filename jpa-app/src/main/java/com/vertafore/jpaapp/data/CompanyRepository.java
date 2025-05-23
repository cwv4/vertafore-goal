package com.vertafore.jpaapp.data;

import com.vertafore.jpaapp.model.Company;

import java.util.Optional;

public interface CompanyRepository {

    Optional<Company> save(Company company);
    Optional<Company> getCompanyById(Long id);
    void deleteCompany(Company company);

}
