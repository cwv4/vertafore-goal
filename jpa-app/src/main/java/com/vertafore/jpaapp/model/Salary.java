package com.vertafore.jpaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salaries")
@Data @NoArgsConstructor @AllArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salary_id")
    private Long id;

    private String company;
    private Integer level;
    private Integer bonusPercentage;
    private Double startingSalary;
    private Double currentSalary;
    private Boolean activeFlag;
    private String title;

    public Salary(String company, Integer level, Integer bonusPercentage, Double startingSalary, Double currentSalary, Boolean activeFlag, String title) {
        this.company = company;
        this.level = level;
        this.bonusPercentage = bonusPercentage;
        this.startingSalary = startingSalary;
        this.currentSalary = currentSalary;
        this.activeFlag = activeFlag;
        this.title = title;
    }
}
