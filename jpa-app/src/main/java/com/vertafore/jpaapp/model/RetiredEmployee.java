package com.vertafore.jpaapp.model;

import jakarta.persistence.Entity;
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
public class RetiredEmployee extends Employee {

    private Boolean pension;

    public RetiredEmployee(String firstName, String lastName, Integer yearsExperience, List<Company> companies, Boolean pension) {
        super(firstName, lastName, yearsExperience, companies);
        this.pension = pension;
    }
}
