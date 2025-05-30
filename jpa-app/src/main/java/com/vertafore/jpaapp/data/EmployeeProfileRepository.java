package com.vertafore.jpaapp.data;

import com.vertafore.jpaapp.model.EmployeeProfile;

import java.util.Optional;

public interface EmployeeProfileRepository {

    Optional<EmployeeProfile> save(EmployeeProfile employeeProfile);
    Optional<EmployeeProfile> getEmployeeProfileById(Long id);
    void deleteEmployeeProfile(EmployeeProfile employeeProfile);

}
