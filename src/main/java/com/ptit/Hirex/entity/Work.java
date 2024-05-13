package com.ptit.Hirex.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work")
@Builder
public class Work {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    
    private Date startTime;

    private Date endTime;

    private LocalDate startDate;

    private LocalDate endDate;
    
    private String jobPosition;
    
	private String typeWork;
    
    private String jobLocation;
    
    private String typeJob;
    
    private String specialize;
  
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    
    private String description;
    
    private Long wage;
    
    @ManyToMany
    @JoinTable(
            name = "work_required_ability",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private List<Ability> requiredAbilities;

    @ManyToOne
    @JoinColumn(name = "expert_id", referencedColumnName = "id")
    private Expert expert;

    @ManyToOne
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;

    @CreatedDate
    private Instant createOn;
}
