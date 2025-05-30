package com.vertafore.jpaapp;

import com.vertafore.jpaapp.data.CompanyRepository;
import com.vertafore.jpaapp.data.EmployeeProfileRepository;
import com.vertafore.jpaapp.data.EmployeeRepository;
import com.vertafore.jpaapp.data.SalaryRepository;
import com.vertafore.jpaapp.model.ActiveEmployee;
import com.vertafore.jpaapp.model.Company;
import com.vertafore.jpaapp.model.Employee;
import com.vertafore.jpaapp.model.EmployeeProfile;
import com.vertafore.jpaapp.model.RetiredEmployee;
import com.vertafore.jpaapp.model.Salary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
@EntityScan("com.vertafore.jpaapp")
@EnableJpaRepositories
public class JpaAppApplication {

    static CompanyRepository companyRepository;
    static EmployeeRepository employeeRepository;
    static SalaryRepository salaryRepository;
    static EmployeeProfileRepository employeeProfileRepository;

    public JpaAppApplication(CompanyRepository companyRepository, EmployeeRepository employeeRepository, SalaryRepository salaryRepository, EmployeeProfileRepository employeeProfileRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
        this.salaryRepository = salaryRepository;
        this.employeeProfileRepository = employeeProfileRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);


        Employee employee1 = new Employee("Bob", "Smith", 20, new ArrayList<>());
        Employee employee2 = new Employee("George", "Miller", 3, new ArrayList<>());
        employee1 = employeeRepository.save(employee1).get();
        employee2 =  employeeRepository.save(employee2).get();

        Salary salary = new Salary(employee2, 4, 3000, 50000.0, 75000.0, true, "Software Man");
        salary = salaryRepository.save(salary).get();

        Company company = new Company("Kerrytown Enterprises", "Georgetown", "IN", "46555", "USA", new ArrayList<>(), List.of(salary));
        company.addEmployee(employee2);
        company = companyRepository.save(company).get();

        log.info("Employee1: {}\nEmployee2: {}\n Company: {}\n Salary: {}", employee1, employee2, company, salary);

        employee1.setFirstName("Bobby Fabulous");
        employee1 = employeeRepository.save(employee1).get();

        ActiveEmployee activeEmployee = new ActiveEmployee("Joseph", "White", 4, List.of(company), "Brake Calipers", 12000.0);
        RetiredEmployee retiredEmployee = new RetiredEmployee("John", "Browne", 10, List.of(company), true);

        employeeRepository.save(activeEmployee);
        employeeRepository.save(retiredEmployee);

        Employee returnedEmployee = employeeRepository.getEmployeeById(1L).get();
        log.info(returnedEmployee.toString());

        employeeRepository.deleteEmployee(employee1);

        EmployeeProfile employeeProfile = new EmployeeProfile("gmill", "1a2b3c", "gmill89@email.net", "George Guy", employee2);
        employeeProfileRepository.save(employeeProfile);
    }
}
