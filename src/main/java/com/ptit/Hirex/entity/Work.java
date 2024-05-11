package com.ptit.Hirex.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work")
public class Work {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "work_required_ability",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private List<Ability> requiredAbilities;

    @ManyToMany
    @JoinTable(
            name = "work_optional_ability",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private List<Ability> optionalAbilities;

    @ManyToOne
    @JoinColumn(name = "expert_id", referencedColumnName = "id")
    private Expert expert;

    @ManyToOne
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;
    // ditme sai cu r

    @ManyToMany
    @JoinTable(
        name = "work_employee", 
        joinColumns = @JoinColumn(name = "work_id"), 
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;

    @CreatedDate
    private Instant createOn;
}
