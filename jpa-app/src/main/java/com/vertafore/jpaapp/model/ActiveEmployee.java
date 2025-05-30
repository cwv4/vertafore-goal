package com.vertafore.jpaapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ActiveEmployee extends Employee {

    private String currentProjectAssignment;

    @Transient
    private Double totalCompensation;

    public ActiveEmployee(String firstName, String lastName, Integer yearsExperience, List<Company> companies, String currentProjectAssignment, Double totalCompensation) {
        super(firstName, lastName, yearsExperience, companies);
        this.currentProjectAssignment = currentProjectAssignment;
        this.totalCompensation = totalCompensation;
    }
}
