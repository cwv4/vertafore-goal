package com.vertafore.jpaapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@ToString(exclude = {"salaries", "employees"})
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Long id;

    private String name;
    private String city;
    private String state;
    private String zip;
    private String country;

    @ManyToMany(mappedBy = "companies", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salary> salaries;

    public Company(String name, String city, String state, String zip, String country, List<Employee> employees, List<Salary> salaries) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.employees = employees;
        this.salaries = salaries;
    }

    public void addEmployee(Employee employee) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        if (!employees.contains(employee)) {
            this.employees.add(employee);
            employee.addCompany(this);
        }
    }
}
