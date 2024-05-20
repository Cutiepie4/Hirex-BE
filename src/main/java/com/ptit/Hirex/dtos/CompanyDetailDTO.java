package com.ptit.Hirex.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDetailDTO {
    private Long id;
    private String name;
    private String shortName;
    private String description; 
    private int employeeSize;
    private String headOffice;
    private String industry;
    private String website;
    private String imageBase64;
    private Long employerId;
    private double avgOverallRate;
    private double avgSalaryRate;
    private double avgTrainingRate;
    private double avgManagementRate;
    private double avgCultureRate;
    private double avgOfficeRate;
    private long recommendPercent;
    private long fiveOverallRate;
    private long fourOverallRate;
    private long threeOverallRate;
    private long twoOverallRate;
    private long oneOverallRate;
    private List<ReviewDTO> reviews;
    private List<WorkCompanyDTO> works;
    
}
