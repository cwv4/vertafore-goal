package com.vertafore.jpaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "salaries")
@Getter
@Setter
@ToString(exclude = "employee")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salary_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    private Integer level;
    private Integer bonusPercentage;
    private Double startingSalary;
    private Double currentSalary;
    private Boolean activeFlag;
    private String title;

    public Salary(Employee employee, Integer level, Integer bonusPercentage, Double startingSalary, Double currentSalary, Boolean activeFlag, String title) {
        this.employee = employee;
        this.level = level;
        this.bonusPercentage = bonusPercentage;
        this.startingSalary = startingSalary;
        this.currentSalary = currentSalary;
        this.activeFlag = activeFlag;
        this.title = title;
    }
}
