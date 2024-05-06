package com.ptit.Hirex.dtos;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {
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
    
    private MultipartFile file;
}
