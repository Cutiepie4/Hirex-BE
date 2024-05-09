package com.ptit.Hirex.dtos;

import java.util.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkDTO {
    private int id;

    private String name;

    private String address;

    private String description;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalDate startDate;

    private LocalDate endDate;

    // private List<Ability> requiredAbilities;
    // private List<Ability> optionalAbilities;
    private ExpertDTO expert;
    // private Employer employer;
    // private List<Employee> employees;
    private Instant createOn;
}
