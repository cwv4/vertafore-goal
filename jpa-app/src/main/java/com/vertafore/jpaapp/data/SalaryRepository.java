package com.vertafore.jpaapp.data;

import com.vertafore.jpaapp.model.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryRepository {

    Optional<Salary> save(Salary salary);
    Optional<Salary> getSalaryById(Long id);
    void deleteSalary(Salary salary);
    List<Salary> getSalariesWithLevelGreaterThan(int level);

}
