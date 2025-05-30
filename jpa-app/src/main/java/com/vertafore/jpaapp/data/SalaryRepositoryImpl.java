package com.vertafore.jpaapp.data;

import com.vertafore.jpaapp.model.Salary;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalaryRepositoryImpl implements SalaryRepository {

    EntityManager entityManager;

    public SalaryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Optional<Salary> save(Salary salary) {
        return Optional.of(entityManager.merge(salary));
    }

    @Override
    public Optional<Salary> getSalaryById(Long id) {
        Salary salary = entityManager.find(Salary.class, id);
        return salary != null ? Optional.of(salary) : Optional.empty();
    }

    @Override
    public void deleteSalary(Salary salary) {
        if (entityManager.contains(salary)) {
            entityManager.remove(salary);
        } else {
            entityManager.remove(entityManager.merge(salary));
        }
    }
}
