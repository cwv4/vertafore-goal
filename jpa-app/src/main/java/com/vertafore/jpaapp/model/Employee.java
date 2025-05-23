package com.vertafore.jpaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data @NoArgsConstructor @AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;

    private String firstName;
    private String lastName;
    private Integer yearsExperience;
    @Transient
    private Double totalCompensation;

    public Employee(String firstName, String lastName, Integer yearsExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsExperience = yearsExperience;
    }
}
