package com.vertafore.jpaapp.data;

import com.vertafore.jpaapp.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    EntityManager entityManager;

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Optional<Employee> save(Employee employee) {
        return Optional.of(entityManager.merge(employee));
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee != null ? Optional.of(employee) : Optional.empty();
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        if (entityManager.contains(employee)) {
            entityManager.remove(employee);
        } else {
            entityManager.remove(entityManager.merge(employee));
        }
    }
}
