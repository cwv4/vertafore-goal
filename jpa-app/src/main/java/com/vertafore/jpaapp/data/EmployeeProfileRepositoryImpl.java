package com.vertafore.jpaapp.data;

import com.vertafore.jpaapp.model.EmployeeProfile;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeProfileRepositoryImpl implements EmployeeProfileRepository {

    private final EntityManager entityManager;

    public EmployeeProfileRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Optional<EmployeeProfile> save(EmployeeProfile employeeProfile) {
        return Optional.of(entityManager.merge(employeeProfile));
    }

    @Override
    public Optional<EmployeeProfile> getEmployeeProfileById(Long id) {
        EmployeeProfile employeeProfile = entityManager.find(EmployeeProfile.class, id);
        return employeeProfile != null ? Optional.of(employeeProfile) : Optional.empty();
    }

    @Override
    @Transactional
    public void deleteEmployeeProfile(EmployeeProfile employeeProfile) {
        if (entityManager.contains(employeeProfile)) {
            entityManager.remove(employeeProfile);
        } else {
            entityManager.remove(entityManager.merge(employeeProfile));
        }
    }
}
