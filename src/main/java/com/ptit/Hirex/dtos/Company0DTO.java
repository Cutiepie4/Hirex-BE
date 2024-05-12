package com.ptit.Hirex.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company0DTO {
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
    
}
