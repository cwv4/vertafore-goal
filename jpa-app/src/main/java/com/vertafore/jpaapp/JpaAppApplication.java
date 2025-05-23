package com.vertafore.jpaapp;

import com.vertafore.jpaapp.data.CompanyRepository;
import com.vertafore.jpaapp.data.EmployeeRepository;
import com.vertafore.jpaapp.data.SalaryRepository;
import com.vertafore.jpaapp.model.Company;
import com.vertafore.jpaapp.model.Employee;
import com.vertafore.jpaapp.model.Salary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Slf4j
@EntityScan("com.vertafore.jpaapp")
@EnableJpaRepositories
public class JpaAppApplication {

    static CompanyRepository companyRepository;
    static EmployeeRepository employeeRepository;
    static SalaryRepository salaryRepository;

    public JpaAppApplication(CompanyRepository companyRepository, EmployeeRepository employeeRepository, SalaryRepository salaryRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
        this.salaryRepository = salaryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
        Employee employee1 = new Employee("Bob", "Smith", 20);
        Employee employee2 = new Employee("George", "Miller", 3);
        Company company = new Company("Georgetown", "IN", "46555", "USA");
        Salary salary = new Salary("Physics Enterprises, Inc.",4, 3000, 50000.0, 75000.0, true, "Software Man");

        log.info("Employee1: {}\nEmployee2: {}\n Company: {}\n Salary: {}", employee1, employee2, company, salary);

        companyRepository.save(company);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        salaryRepository.save(salary);

        employee1.setFirstName("Boberino");
        employeeRepository.save(employee1);

        Employee returnedEmployee = employeeRepository.getEmployeeById(1L).get();
        log.info(returnedEmployee.toString());

        employeeRepository.deleteEmployee(employee1);
    }
}
