package com.ptit.Hirex.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appreciation")
public class Appreciation extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String award;
    private String achievement;
    private String endDate;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    
    @ManyToOne
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    private Work work;
    
}
