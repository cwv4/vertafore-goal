package com.vertafore.jpaapp.data;

import com.vertafore.jpaapp.model.Company;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyRepositoryImpl implements CompanyRepository {
    EntityManager entityManager;

    public CompanyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Optional<Company> save(Company company) {
        return Optional.of(entityManager.merge(company));
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        Company company = entityManager.find(Company.class, id);
        return company != null ? Optional.of(company) : Optional.empty();
    }

    @Override
    @Transactional
    public void deleteCompany(Company company) {
        if (entityManager.contains(company)) {
            entityManager.remove(company);
        } else {
            entityManager.remove(entityManager.merge(company));
        }
    }
}
