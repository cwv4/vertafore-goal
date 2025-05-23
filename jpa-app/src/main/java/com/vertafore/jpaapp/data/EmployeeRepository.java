package com.vertafore.jpaapp.data;

import com.vertafore.jpaapp.model.Employee;

import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> save(Employee employee);
    Optional<Employee> getEmployeeById(Long id);
    void deleteEmployee(Employee employee);

}
