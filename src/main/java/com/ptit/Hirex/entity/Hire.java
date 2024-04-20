package com.ptit.Hirex.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hire")
public class Hire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @OneToMany(mappedBy = "hire", cascade = CascadeType.ALL)
    // private List<Schedule> scheduleList;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
