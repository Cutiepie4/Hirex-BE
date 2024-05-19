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
public class WorkEmployerDTO {
    private int id;

    private String name;

    private String address;

    private List<EmployeeDTO> employees;
    private List<ResumeWorkDTO> resumeWorks;

    private CompanyDTO company;

    private Instant createOn;
}
