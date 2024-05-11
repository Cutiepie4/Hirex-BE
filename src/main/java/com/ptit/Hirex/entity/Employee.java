package com.ptit.Hirex.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@Builder
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "about")
    private String about;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Experience> experiences;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Education> educations;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Certification> Certification;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Resume> resumes;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Skill> skills;
}