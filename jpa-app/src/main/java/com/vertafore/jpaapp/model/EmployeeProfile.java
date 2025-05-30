package com.vertafore.jpaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee_profiles")
@Getter
@Setter
@ToString(exclude = "employee")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_profile_id")
    private Long id;

    private String userName;
    private String password;
    private String email;
    private String title;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public EmployeeProfile(String userName, String password, String email, String title, Employee employee) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.title = title;
        this.employee = employee;
    }
}
