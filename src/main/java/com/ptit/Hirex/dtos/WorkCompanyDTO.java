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
public class WorkCompanyDTO {
    private int id;

    private String name;

    private String address;

    private String description;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalDate startDate;

    private LocalDate endDate;

    private String jobPosition;
    
	private String typeWork;
    
    private String typeJob;

    private Long wage;

    private ExpertDTO expert;

    private Instant createOn;
}
